package com.example.bmo_genc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
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

    @OneToOne
    @JoinColumn(name = "university_id", nullable = false)
    private University university;
}
