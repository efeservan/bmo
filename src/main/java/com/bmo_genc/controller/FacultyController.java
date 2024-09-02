package com.bmo_genc.controller;

import com.bmo_genc.dto.FacultyDTO;
import com.bmo_genc.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@AllArgsConstructor
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/add")
    public ResponseEntity<FacultyDTO> addFaculty(@RequestBody FacultyDTO facultyDTO) {
        FacultyDTO createdFacultyDTO = facultyService.createFaculty(facultyDTO);
        return ResponseEntity.ok(createdFacultyDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FacultyDTO> updateFaculty(@PathVariable Long id,@RequestBody FacultyDTO facultyDTO) {
        try {
            return ResponseEntity.ok(facultyService.updateFaculty(id, facultyDTO));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<FacultyDTO>> getAllFaculties(){
        List<FacultyDTO> faculties = facultyService.getAllFaculties();
        return ResponseEntity.ok(faculties);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyDTO> getFacultyById(@PathVariable Long id) {
        FacultyDTO facultyDTO = facultyService.getFacultyById(id);
        return ResponseEntity.ok(facultyDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
}
