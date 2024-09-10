package com.bmo_genc.controller;

import com.bmo_genc.dto.UniversityDTO;
import com.bmo_genc.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/university")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @PostMapping("/add")
    public ResponseEntity<UniversityDTO> addUniversity(@RequestBody UniversityDTO universityDTO){
        UniversityDTO createdUniversity = universityService.addUniversity(universityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUniversity);
    }

    @GetMapping("/all")
    public List<UniversityDTO> getAllUniversities(){
        List<UniversityDTO> universities = universityService.getAllUniversities();
        return ResponseEntity.ok(universities).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversityDTO> getUniversityById(@PathVariable("id") Long id){
        UniversityDTO universityDTO = universityService.getUniversity(id);
        return ResponseEntity.ok(universityDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UniversityDTO> updateUniversity(@RequestBody UniversityDTO universityDTO, @PathVariable Long id){
        UniversityDTO updatedUniversityDTO = universityService.updateUniversity(id, universityDTO);
        return ResponseEntity.ok(updatedUniversityDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable Long id){
        universityService.deleteUniversity(id);
        return ResponseEntity.noContent().build();
    }

}
