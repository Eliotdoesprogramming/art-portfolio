package com.talentpath.artportfolio.models;

import java.time.LocalDate;
import java.util.Date;

public class License {
    Integer requestId;

    LocalDate validUntil;

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }



    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }
}
