package com.talentpath.artportfolio.daos;

import com.talentpath.artportfolio.models.Image;
import com.talentpath.artportfolio.models.LicenseRequest;

import java.util.List;

public interface ArtDao {
    List<Image> getAllImages();

    Integer addLicenseRequest(LicenseRequest licenseRequest);

    Image getImageById(Integer id);
}
