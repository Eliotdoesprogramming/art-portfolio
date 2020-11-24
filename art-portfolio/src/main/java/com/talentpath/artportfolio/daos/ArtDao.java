package com.talentpath.artportfolio.daos;

import com.talentpath.artportfolio.models.CommissionRequest;
import com.talentpath.artportfolio.models.Image;
import com.talentpath.artportfolio.models.License;
import com.talentpath.artportfolio.models.LicenseRequest;

import java.util.List;

public interface ArtDao {
    List<Image> getAllImages();



    Image getImageById(Integer id);






}
