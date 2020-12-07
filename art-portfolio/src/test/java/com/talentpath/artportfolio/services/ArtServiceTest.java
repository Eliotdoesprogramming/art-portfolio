package com.talentpath.artportfolio.services;

import com.talentpath.artportfolio.exceptions.InvalidCharacterException;
import com.talentpath.artportfolio.exceptions.InvalidEnumException;
import com.talentpath.artportfolio.exceptions.InvalidIndexException;
import com.talentpath.artportfolio.models.*;
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
@ActiveProfiles("testing")
class ArtServiceTest {
    @Autowired
    ArtService service;
//production tests
//    @Test
//    public void updateStatus() throws InvalidEnumException {
//        Integer id = 1;
//        COMMISSION_STATUS status = COMMISSION_STATUS.ACCEPTED;
//        service.updateCommission(id,status);
//    }
//    @Test
//    public void getPending(){
//        List<LicenseRequest> licenseRequestList=service.getPendingLicenseRequests();
//        for (LicenseRequest r: licenseRequestList
//             ) {
//            //System.out.println(r.getId());
//        }
//    }
//    @Test
//    public void searchTest() throws InvalidCharacterException {
//        List<Image> images =service.searchImage("tree");
//       // System.out.println(images.get(0).getName());
//    }
    @Test
    public void getAllImage(){
        //golden path
        List<Image> allImages = service.getAllImages();
        assertTrue(!allImages.equals(null));
        assertTrue(allImages.size()==2);
    }
    @Test
    void getImageById() throws InvalidIndexException {
        Image img = service.getImageById(0);
        Image img1 = service.getImageById(1);
        
        assertFalse(img.getCategory().equals(null));
        assertFalse(img.getDescription().equals(""));
        assertFalse(img.getDescription().equals(null));
        assertFalse(img.getDescription().equals(""));
        assertFalse(img.getName().equals(null));
        assertFalse(img.getName().equals(""));
        assertTrue(img.getId()==0);
        assertFalse(img.getId()!=null);
        assertFalse(img.getPath().equals(""));
        assertFalse(img.getPath().equals(null));

        assertFalse(img1.getCategory().equals(null));
        assertFalse(img1.getDescription().equals(""));
        assertFalse(img1.getDescription().equals(null));
        assertFalse(img1.getDescription().equals(""));
        assertFalse(img1.getName().equals(null));
        assertFalse(img1.getName().equals(""));
        assertTrue(img1.getId()==1);
        assertFalse(img1.getId()!=null);
        assertFalse(img1.getPath().equals(""));
        assertFalse(img1.getPath().equals(null));
        
    }
    @Test
    void getImageByBadId()  {
        try{
            Image img = service.getImageById(99);
            fail();
        }catch(InvalidIndexException e){

        }



    }
    @Test
    void getImageByNullId()  {
        try{
            Image img = service.getImageById(null);
            fail();
        }catch(InvalidIndexException e){

        }



    }
    @Test
    void getImageByNegativeId()  {
        try{
            Image img = service.getImageById(-1);
            fail();
        }catch(InvalidIndexException e){

        }

    }
    @Test
    void grantLicense() throws InvalidIndexException {
        // golden path
        boolean b = service.grantLicense(1);
        assertTrue(b);
        List<LicenseView> allLicense = service.viewLicenses();
        assertFalse(allLicense.stream().filter(n -> n.getReqId() == 1).findAny().equals(null));

    }
    @Test
    void grantLicenseBadId(){
        try{
            service.grantLicense(99999);
            fail();
        }catch(InvalidIndexException e){

        }
    }
    @Test
    void grantLicenseNegativeId(){
        try{
            service.grantLicense(-1);
            fail();
        }catch(InvalidIndexException e){

        }
    }
    @Test
    void grantLicenseNullId(){
        try{
            service.grantLicense(null);
            fail();
        }catch(InvalidIndexException e){

        }
    }

}