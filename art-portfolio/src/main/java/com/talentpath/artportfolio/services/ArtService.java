package com.talentpath.artportfolio.services;

import com.talentpath.artportfolio.daos.ArtDao;
import com.talentpath.artportfolio.daos.CommissionDao;
import com.talentpath.artportfolio.daos.LicenseDao;
import com.talentpath.artportfolio.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ArtService {

    ArtDao artDao;

    LicenseDao licenseDao;

    CommissionDao commissionDao;

    @Autowired
    public ArtService(ArtDao artDao,LicenseDao licenseDao, CommissionDao commissionDao){
        this.artDao=artDao;
        this.licenseDao=licenseDao;
        this.commissionDao=commissionDao;
    }

    public List<Image> getAllImages() {
        return artDao.getAllImages();
    }

    public Integer addRequest(LicenseRequest licenseRequest) {
        return licenseDao.addLicenseRequest(licenseRequest);
    }

    public Image getImageById(Integer id) {
        return artDao.getImageById(id);
    }

    public Integer addCommissionRequest(CommissionRequest req) {
        return commissionDao.addCommissionRequest(req);
    }
    public boolean updateCommission(Integer id, COMMISSION_STATUS status){return commissionDao.updateStatus(id,status);}

    public boolean grantLicense(Integer id) {
        LicenseRequest toGrant = licenseDao.getLicenseById(id);
        License license = new License();
        license.setImageId(toGrant.getImageId());
        license.setRequestId(toGrant.getId());
        license.setValidUntil(LocalDate.now().plusYears(1));

        return licenseDao.addLicense(license);

    }

    public List<LicenseRequest> getAllLicenseRequests() {
        return licenseDao.getLicenseRequests();
    }
    public List<LicenseRequest> getPendingLicenseRequests(){return getPendingLicenseRequests();}

    public List<CommissionRequest> getAllCommissions() {
        return commissionDao.getCommissionRequests();
    }

    public List<CommissionRequest> getPendingCommissions() {
        return commissionDao.getPendingCommissions();
    }
}
