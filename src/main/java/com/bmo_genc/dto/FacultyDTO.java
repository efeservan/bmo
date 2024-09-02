package com.bmo_genc.dto;

import lombok.Data;

import java.util.List;

@Data
public class FacultyDTO {
    private Long id;
    private String facultyName;
//    private List<String> departmentNames;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

//    public List<String> getDepartmentNames() {
//        return departmentNames;
//    }
//
//    public void setDepartmentNames(List<String> departmentNames) {
//        this.departmentNames = departmentNames;
//    }
}
