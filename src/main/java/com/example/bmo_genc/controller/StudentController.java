package com.example.bmo_genc.controller;

import com.example.bmo_genc.model.Student;
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
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student createdStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students).getBody();
    }

}
