package com.bmo_genc.controller;

import com.bmo_genc.dto.StudentDTO;
import com.bmo_genc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO createdStudentDTO = studentService.addStudent(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudentDTO);
    }

    // Öğrenciyi arka planda kaydet.
    @PostMapping("/addAsync")
    public ResponseEntity<String> addStudentAsync(@RequestBody StudentDTO studentDTO) {
        studentService.addStudentAsync(studentDTO); // Asenkron işlemi başlatır.
        return ResponseEntity.ok("Student registration started in the background.");
    }

    @PutMapping("/update")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO){
        try{
            return ResponseEntity.ok(studentService.updateStudent(studentDTO));
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDTO> findStudentById(@PathVariable Long id) {
        StudentDTO studentDTO = studentService.findStudentById(id);
        return ResponseEntity.ok(studentDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
