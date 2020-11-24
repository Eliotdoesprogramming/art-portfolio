package com.talentpath.artportfolio.services;

import com.talentpath.artportfolio.daos.ArtDao;
import com.talentpath.artportfolio.daos.CommissionDao;
import com.talentpath.artportfolio.daos.LicenseDao;
import com.talentpath.artportfolio.models.CommissionRequest;
import com.talentpath.artportfolio.models.Image;
import com.talentpath.artportfolio.models.License;
import com.talentpath.artportfolio.models.LicenseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean grantLicense(Integer id) {
        LicenseRequest toGrant = licenseDao.getLicenseById(id);
        License license = new License();
        license.setImageId(toGrant.getImageId());
        license.setRequestId(toGrant.getId());
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, 1); // to get previous year add -1
        Date nextYear = cal.getTime();
        license.setValidUntil(nextYear);
        return licenseDao.addLicense(license);

    }

    public List<LicenseRequest> getAllLicenseRequests() {
        return licenseDao.getLicenseRequests();
    }
}
