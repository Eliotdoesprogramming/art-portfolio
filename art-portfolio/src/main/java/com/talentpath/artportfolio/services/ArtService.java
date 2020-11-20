package com.talentpath.artportfolio.services;

import com.talentpath.artportfolio.daos.ArtDao;
import com.talentpath.artportfolio.models.Image;
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
}
