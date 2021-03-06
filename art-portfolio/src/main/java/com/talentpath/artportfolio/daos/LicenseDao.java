package com.talentpath.artportfolio.daos;

import com.talentpath.artportfolio.models.License;
import com.talentpath.artportfolio.models.LicenseRequest;
import com.talentpath.artportfolio.models.LicenseView;

import java.util.List;

public interface LicenseDao {
    List<LicenseRequest> getLicenseRequests();
    List<LicenseRequest> getPendingLicenseRequests();
    LicenseRequest getLicenseById(Integer id);

    boolean addLicense(License license);
    Integer addLicenseRequest(LicenseRequest licenseRequest);

    List<LicenseView> viewLicenses();
    Integer revokeLicense(Integer id);
}
