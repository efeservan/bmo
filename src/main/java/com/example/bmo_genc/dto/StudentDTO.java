package com.example.bmo_genc.dto;

import lombok.Data;

@Data
public class StudentDTO {

    private Long tcNo;
    private String name;
    private UniversityDTO university;

    public Long getTcNo() {
        return tcNo;
    }

    public void setTcNo(Long tcNo) {
        this.tcNo = tcNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UniversityDTO getUniversity() {
        return university;
    }

    public void setUniversity(UniversityDTO university) {
        this.university = university;
    }
}