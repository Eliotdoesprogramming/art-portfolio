package com.talentpath.artportfolio.models;

public class LicenseView {
    private Integer reqId;
    private String licensedName;
    private String licenseExpires;
    private Integer imageId;
    private String imageName;

    public Integer getReqId() {
        return reqId;
    }

    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public String getLicensedName() {
        return licensedName;
    }

    public void setLicensedName(String licensedName) {
        this.licensedName = licensedName;
    }

    public String getLicenseExpires() {
        return licenseExpires;
    }

    public void setLicenseExpires(String licenseExpires) {
        this.licenseExpires = licenseExpires;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
