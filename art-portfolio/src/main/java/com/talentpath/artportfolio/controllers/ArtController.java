package com.talentpath.artportfolio.controllers;

import com.talentpath.artportfolio.models.CommissionRequest;
import com.talentpath.artportfolio.models.Image;
import com.talentpath.artportfolio.models.LicenseRequest;
import com.talentpath.artportfolio.models.LicenseRqFromJson;
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
    public List<Image> getAllImages(){
        return service.getAllImages();
    }
    @GetMapping("/images/{id}")
    public Image getImageById(@PathVariable Integer id){
        return service.getImageById(id);
    }

    @GetMapping("/admin/licenseReqs")
    public List<LicenseRequest> allLicenseRequests(){
        return service.getAllLicenseRequests();
    }

    @PostMapping(path="/licenseRequest/add", consumes = "application/json", produces = "application/json")
    public Integer addRequest(@RequestBody LicenseRqFromJson licenseRequest){
        System.out.println(licenseRequest);
        LicenseRequest toAdd = new LicenseRequest(licenseRequest);
        return service.addRequest(toAdd);
    }
    @PostMapping(path="/commissionRequest/add", consumes = "application/json", produces = "application/json")
    public Integer addCommissionRequest(@RequestBody CommissionRequest req){
        return service.addCommissionRequest(req);
    }
    @PostMapping("/grantLicense/{id}")
    public boolean grantLicense(@PathVariable Integer id){
        return service.grantLicense(id);

    }


}
