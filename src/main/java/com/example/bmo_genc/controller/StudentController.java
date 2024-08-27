package com.example.bmo_genc.controller;

import com.example.bmo_genc.dto.StudentDTO;
import com.example.bmo_genc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO createdStudentDTO = studentService.addStudent(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudentDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

}
