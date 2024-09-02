package com.bmo_genc.dto;

import lombok.Data;

@Data
public class UniversityDTO {

    private Long id;

    private String universityName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}