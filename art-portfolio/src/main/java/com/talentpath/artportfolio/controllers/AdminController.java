package com.talentpath.artportfolio.controllers;


import com.talentpath.artportfolio.models.COMMISSION_STATUS;
import com.talentpath.artportfolio.models.CommissionRequest;
import com.talentpath.artportfolio.models.LicenseRequest;
import com.talentpath.artportfolio.services.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    ArtService service;

    @GetMapping("/getPendingLicenseReqs")
    public List<LicenseRequest> pendingLicenseRequests(){return service.getPendingLicenseRequests();}
    @GetMapping("/licenseReqs")
    public List<LicenseRequest> allLicenseRequests(){
        return service.getAllLicenseRequests();
    }
    @GetMapping("/commissions")
    public List<CommissionRequest> allCommissions(){return service.getAllCommissions();}
    @GetMapping("/commissions/pending")
    public List<CommissionRequest> pendingCommissions(){return service.getPendingCommissions();}
    @PostMapping("/updateCommission/{id}/{status}")
    public boolean updateCommission(@PathVariable Integer id, @PathVariable Integer status){
        COMMISSION_STATUS enumStat = COMMISSION_STATUS.PENDING;
        switch(status){
            case 0:
                enumStat = COMMISSION_STATUS.PENDING;
                break;
            case 1:
                enumStat = COMMISSION_STATUS.ACCEPTED;
                break;
            case 2:
                enumStat = COMMISSION_STATUS.REJECTED;
                break;
            case 3:
                enumStat=COMMISSION_STATUS.WORKING;
                break;
            case 4:
                enumStat=COMMISSION_STATUS.FINISHED;
                break;

        }
        return service.updateCommission(id,enumStat);
    }
}
