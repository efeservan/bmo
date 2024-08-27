package com.example.bmo_genc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tcNo;

    private Long studentNo;

    private String name;

    private String surname;

    private String fatherName;

    private String motherName;

    private String homeTown;

    private LocalDate birthDate;

    private String city;

    private String bloodGroup;

    private int classDegree;

    private Long phoneNumber;

    @ManyToOne
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    public Long getId() {
        return id;
    }

    public Long getTcNo() {
        return tcNo;
    }

    public Long getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public int getClassDegree() {
        return classDegree;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public University getUniversity() {
        return university;
    }

    public void setTcNo(Long tcNo) {
        this.tcNo = tcNo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentNo(Long studentNo) {
        this.studentNo = studentNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setClassDegree(int classDegree) {
        this.classDegree = classDegree;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
