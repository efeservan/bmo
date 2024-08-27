package com.example.bmo_genc.controller;

import com.example.bmo_genc.model.University;
import com.example.bmo_genc.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @PostMapping("/add")
    public ResponseEntity<University> addUniversity(@RequestBody University university){
        University createdUniversity = universityService.addUniversity(university);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUniversity);
    }

    @GetMapping
    public List<University> getAllUniversities(){
        List<University> universities = universityService.getAllUniversities();
        return ResponseEntity.ok(universities).getBody();
    }
}
