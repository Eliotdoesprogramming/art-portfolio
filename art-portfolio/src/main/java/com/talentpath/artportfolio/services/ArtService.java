package com.talentpath.artportfolio.services;

import com.talentpath.artportfolio.daos.ArtDao;
import com.talentpath.artportfolio.models.Image;
import com.talentpath.artportfolio.models.LicenseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
