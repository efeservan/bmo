package com.bmo_genc.dto;

import lombok.Data;

@Data
public class MentorDTO {

    private Long id;
    private String fullName;
    private String email;
    private Long bmoId;
    private Long phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getBmoId() {
        return bmoId;
    }

    public void setBmoId(Long bmoId) {
        this.bmoId = bmoId;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
