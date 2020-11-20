package com.talentpath.artportfolio.controllers;

import com.talentpath.artportfolio.models.Image;
import com.talentpath.artportfolio.services.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ArtController {
    @Autowired
    ArtService service;
    @GetMapping("/images")
    List<Image> getAllImages(){
        return service.getAllImages();

    }
}
