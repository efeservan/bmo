package com.example.bmo_genc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String facultyName;

//    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
//    private List<Section> sections = new ArrayList<>();

}
