package com.example.bmo_genc.service;

import com.example.bmo_genc.model.Faculty;
import com.example.bmo_genc.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getAllFaculties(){
        return facultyRepository.findAll();
    }

}
