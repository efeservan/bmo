package com.example.bmo_genc.service;

import com.example.bmo_genc.model.University;
import com.example.bmo_genc.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    public University addUniversity(University university){
        return universityRepository.save(university);
    }

    public List<University> getAllUniversities(){
        return universityRepository.findAll();
    }
}
