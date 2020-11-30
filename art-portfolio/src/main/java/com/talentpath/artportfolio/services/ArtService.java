package com.talentpath.artportfolio.services;

import com.talentpath.artportfolio.daos.ArtDao;
import com.talentpath.artportfolio.daos.CommissionDao;
import com.talentpath.artportfolio.daos.LicenseDao;
import com.talentpath.artportfolio.exceptions.InvalidCharacterException;
import com.talentpath.artportfolio.exceptions.InvalidEnumException;
import com.talentpath.artportfolio.exceptions.InvalidIndexException;
import com.talentpath.artportfolio.exceptions.NullExpectedFieldException;
import com.talentpath.artportfolio.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<Image> searchImage(String term) throws InvalidCharacterException {
        if(term.indexOf(';') + term.indexOf('%') + term.indexOf(',') > -3) throw new InvalidCharacterException("dont hack my sql");
        return artDao.searchImage(term);
    }
    public Image getImageById(Integer id) throws InvalidIndexException {
        if(id<0) throw new InvalidIndexException("Invalid index");
        return artDao.getImageById(id);
    }

    public Integer addCommissionRequest(CommissionRequest req) throws NullExpectedFieldException {
        if(req == null) throw new NullExpectedFieldException("null object");
        return commissionDao.addCommissionRequest(req);
    }
    public Integer addRequest(LicenseRequest licenseRequest) throws NullExpectedFieldException {
        if(licenseRequest == null) throw new NullExpectedFieldException("null object");
        return licenseDao.addLicenseRequest(licenseRequest);
    }
    public List<LicenseRequest> getAllLicenseRequests() {
        return licenseDao.getLicenseRequests();
    }
    public List<LicenseRequest> getPendingLicenseRequests(){return licenseDao.getPendingLicenseRequests();}


    public List<CommissionRequest> getAllCommissions() {
        return commissionDao.getCommissionRequests();
    }
    public List<CommissionRequest> getPendingCommissions() {
        return commissionDao.getPendingCommissions();
    }
    public CommissionRequest updateCommission(Integer id, COMMISSION_STATUS status) throws InvalidEnumException {
        if(commissionDao.updateStatus(id,status))
            return commissionDao.getCommissionRequestById(id);
        else{
            throw new InvalidEnumException("tried to enter invalid information in database");
        }
    }


    public boolean grantLicense(Integer id) throws InvalidIndexException {
        if(id<0 | id==null) throw new InvalidIndexException("please enter a positive index");
        LicenseRequest toGrant = licenseDao.getLicenseById(id);
        License license = new License();
        license.setRequestId(toGrant.getId());
        license.setValidUntil(LocalDate.now().plusYears(1));

        return licenseDao.addLicense(license);

    }
    public Integer revokeLicense(Integer id) throws InvalidIndexException {
        if(id<0)throw new InvalidIndexException("invalid index...");
        return licenseDao.revokeLicense(id);}
    public List<LicenseView> viewLicenses(){
        return licenseDao.viewLicenses();
    }
}
