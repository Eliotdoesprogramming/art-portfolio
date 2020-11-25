package com.talentpath.artportfolio.models;

public class CommissionRequest {
    private Integer id;
    private String name;
    private String email;
    private String description;
    private COMMISSION_STATUS status;

    public CommissionRequest(){

    }
    public COMMISSION_STATUS getStatus() {
        return status;
    }

    public void setStatus(COMMISSION_STATUS status) {
        this.status = status;
    }
    //public void setStatus(String status){this.status = COMMISSION_STATUS.valueOf(status);}
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
