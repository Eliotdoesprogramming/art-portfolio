package com.talentpath.artportfolio.controllers;

import com.talentpath.artportfolio.models.Image;
import com.talentpath.artportfolio.models.Request;
import com.talentpath.artportfolio.services.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path="/request/add", consumes = "application/json", produces = "application/json")
    Request addRequest(@RequestBody Request request){
        return service.addRequest(request);
    }
}
