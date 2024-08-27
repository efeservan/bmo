package com.example.bmo_genc.service;

import com.example.bmo_genc.model.Section;
import com.example.bmo_genc.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

//    @Autowired
//    private FacultyRepository facultyRepository;

    public List<Section> getAllSections(){
        return sectionRepository.findAll();
    }
}
