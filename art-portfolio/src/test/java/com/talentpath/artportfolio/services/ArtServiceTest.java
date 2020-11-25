package com.talentpath.artportfolio.services;

import com.talentpath.artportfolio.models.COMMISSION_STATUS;
import com.talentpath.artportfolio.models.LicenseRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("production")
class ArtServiceTest {
    @Autowired
    ArtService service;
    @Test
    public void grantLicense(){
        System.out.println(service.grantLicense(1));
    }

    @Test
    public void updateStatus(){
        Integer id = 1;
        COMMISSION_STATUS status = COMMISSION_STATUS.ACCEPTED;
        service.updateCommission(id,status);
    }
    @Test
    public void getPending(){
        List<LicenseRequest> licenseRequestList=service.getPendingLicenseRequests();
        for (LicenseRequest r: licenseRequestList
             ) {
            System.out.println(r.getId());
        }
    }

}