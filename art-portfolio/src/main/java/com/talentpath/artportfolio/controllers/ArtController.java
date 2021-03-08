package com.talentpath.artportfolio.controllers;

import com.talentpath.artportfolio.exceptions.InvalidCharacterException;
import com.talentpath.artportfolio.exceptions.InvalidIndexException;
import com.talentpath.artportfolio.exceptions.NullExpectedFieldException;
import com.talentpath.artportfolio.models.CommissionRequest;
import com.talentpath.artportfolio.models.Image;
import com.talentpath.artportfolio.models.LicenseRequest;
import com.talentpath.artportfolio.models.LicenseRqFromJson;
import com.talentpath.artportfolio.services.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ArtController {
    @Autowired
    ArtService service;

    @GetMapping("/images")
    public List<Image> getAllImages(){
        return service.getAllImages();
    }
    @GetMapping("/images/{id}")
    public ResponseEntity getImageById(@PathVariable Integer id)  {
        Image foundImage = new Image();
        try{
             foundImage = service.getImageById(id);
        } catch (InvalidIndexException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(foundImage);
    }
    @PostMapping("/images/add")
    public ResponseEntity addImage(@RequestBody Image toAdd){
        Integer id = -1;
        try{
           id= service.addImage(toAdd);
        }catch(Exception ex){
            return ResponseEntity.status(500).body(ex.getMessage());
        }
        return ResponseEntity.ok(id);
    }

    @PostMapping(path="/licenseRequest/add", consumes = "application/json", produces = "application/json")
    public Integer addRequest(@RequestBody LicenseRqFromJson licenseRequest) throws NullExpectedFieldException {
        LicenseRequest toAdd = new LicenseRequest(licenseRequest);
        return service.addRequest(toAdd);
    }
    @PostMapping(path="/commissionRequest/add", consumes = "application/json", produces = "application/json")
    public Integer addCommissionRequest(@RequestBody CommissionRequest req) throws NullExpectedFieldException {
        return service.addCommissionRequest(req);
    }
    @GetMapping("/images/search/{term}")
    public List<Image> searchResults(@PathVariable String term) throws InvalidCharacterException {
        return service.searchImage(term);
    }




}
