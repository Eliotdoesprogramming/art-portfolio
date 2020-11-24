package com.talentpath.artportfolio.services;

import com.talentpath.artportfolio.daos.ArtDao;
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

    ArtDao dao;
    @Autowired
    public ArtService(ArtDao dao){
        this.dao=dao;
    }

    public List<Image> getAllImages() {
        return dao.getAllImages();
    }

    public Integer addRequest(LicenseRequest licenseRequest) {
        return dao.addLicenseRequest(licenseRequest);
    }

    public Image getImageById(Integer id) {
        return dao.getImageById(id);
    }

    public Integer addCommissionRequest(CommissionRequest req) {
        return dao.addCommissionRequest(req);
    }

    public boolean grantLicense(Integer id) {
        LicenseRequest toGrant = dao.getLicenseById(id);
        License license = new License();
        license.setImageId(toGrant.getImageId());
        license.setRequestId(toGrant.getId());
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, 1); // to get previous year add -1
        Date nextYear = cal.getTime();
        license.setValidUntil(nextYear);
        return dao.addLicense(license);

    }

    public List<LicenseRequest> getAllLicenseRequests() {
        return dao.getLicenseRequests();
    }
}
