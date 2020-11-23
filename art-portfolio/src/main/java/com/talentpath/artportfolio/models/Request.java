package com.talentpath.artportfolio.models;

public class Request {
    private Integer id;
    private String name;
    private String email;
    private Boolean isBusiness;
    private String description;
    public Request(){};

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
