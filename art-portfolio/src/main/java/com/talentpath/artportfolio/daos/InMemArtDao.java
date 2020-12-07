package com.talentpath.artportfolio.daos;

import com.talentpath.artportfolio.models.CommissionRequest;
import com.talentpath.artportfolio.models.Image;
import com.talentpath.artportfolio.models.License;
import com.talentpath.artportfolio.models.LicenseRequest;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Profile("testing")
public class InMemArtDao implements ArtDao {
    List<Image> allImages;
    public InMemArtDao(){
        List<Image> allImages = new ArrayList<>();
        Image toAdd1 = new Image();
        toAdd1.setId(0);
        toAdd1.setName("tree");
        toAdd1.setCategory("nature");
        toAdd1.setDescription("some sort of tree");
        toAdd1.setPath("../assets/testimage.jpg");
        allImages.add(toAdd1);
        Image toAdd2 = new Image();
        toAdd2.setName("skull");
        toAdd2.setId(1);
        toAdd2.setCategory("people");
        toAdd2.setDescription("bones");
        toAdd2.setPath("../assets/skullart.jpg");
        allImages.add(toAdd2);
        this.allImages=allImages;
    }
    @Override
    public List<Image> getAllImages() {
        return allImages.stream().collect(Collectors.toList());
    }



    @Override
    public Image getImageById(Integer id) {
        return allImages.stream().filter(image -> image.getId()==id).findAny().orElse(null);
    }

    @Override
    public List<Image> searchImage(String term) {
        return null;
    }


}
