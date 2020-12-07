package com.talentpath.artportfolio.services;

import com.talentpath.artportfolio.exceptions.InvalidCharacterException;
import com.talentpath.artportfolio.exceptions.InvalidEnumException;
import com.talentpath.artportfolio.exceptions.InvalidIndexException;
import com.talentpath.artportfolio.models.COMMISSION_STATUS;
import com.talentpath.artportfolio.models.Image;
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
    public void grantLicense() throws InvalidIndexException {
        //System.out.println(service.grantLicense(1));
        service.grantLicense(1);

    }

    @Test
    public void updateStatus() throws InvalidEnumException {
        Integer id = 1;
        COMMISSION_STATUS status = COMMISSION_STATUS.ACCEPTED;
        service.updateCommission(id,status);
    }
    @Test
    public void getPending(){
        List<LicenseRequest> licenseRequestList=service.getPendingLicenseRequests();
        for (LicenseRequest r: licenseRequestList
             ) {
            //System.out.println(r.getId());
        }
    }
    @Test
    public void searchTest() throws InvalidCharacterException {
        List<Image> images =service.searchImage("tree");
       // System.out.println(images.get(0).getName());
    }

}