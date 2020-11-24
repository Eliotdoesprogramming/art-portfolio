package com.talentpath.artportfolio.models;

public class LicenseRequest {
    private Integer id;
    private Integer imageId;
    private String name;
    private String email;

    private Boolean isBusiness;
    private String description;

    public LicenseRequest(){};
    public LicenseRequest(LicenseRqFromJson buildFrom){
        this.id = buildFrom.getId();
        this.imageId= buildFrom.getImageId();
        this.name= buildFrom.getName();
        this.email=buildFrom.getEmail();
        this.description=buildFrom.getDescription();
        this.isBusiness=(buildFrom.getBusiness().equals("bus"));

    }
    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getBusiness() {
        return isBusiness;
    }

    public void setBusiness(Boolean business) {
        isBusiness = business;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
