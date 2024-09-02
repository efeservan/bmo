package com.bmo_genc.dto;

import lombok.Data;

@Data
public class UniversityDTO {

    private String universityName;

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}