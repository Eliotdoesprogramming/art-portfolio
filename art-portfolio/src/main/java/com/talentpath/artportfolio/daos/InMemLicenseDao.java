package com.talentpath.artportfolio.daos;

import com.talentpath.artportfolio.models.License;
import com.talentpath.artportfolio.models.LicenseRequest;
import com.talentpath.artportfolio.models.LicenseView;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.stream.Collectors;

@Profile("testing")
public class InMemLicenseDao implements LicenseDao{
    private List<LicenseRequest> allRequests;
    private List<License> allLicenses;
    public InMemLicenseDao(){

    }
    @Override
    public List<LicenseRequest> getLicenseRequests() {
        return allRequests.stream().collect(Collectors.toList());
    }

    @Override
    public List<LicenseRequest> getPendingLicenseRequests() {
        List<Integer> requestsIds=allLicenses.stream().map(n-> n.getRequestId()).collect(Collectors.toList());
        return allRequests.stream().filter(n->!requestsIds.contains(n.getId())).collect(Collectors.toList());
    }

    @Override
    public LicenseRequest getLicenseById(Integer id) {
        return allRequests.stream().filter(n->n.getId()==id).findAny().orElse(null);
    }

    @Override
    public boolean addLicense(License license) {
        return allLicenses.add(license);
    }

    @Override
    public Integer addLicenseRequest(LicenseRequest licenseRequest) {

        allRequests.add(licenseRequest);
        return allRequests.size();
    }

    @Override
    public List<LicenseView> viewLicenses() {
        return null;
    }

    @Override
    public Integer revokeLicense(Integer id) {
        return null;
    }
}
