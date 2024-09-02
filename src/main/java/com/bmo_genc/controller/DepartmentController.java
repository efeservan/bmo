package com.bmo_genc.controller;

import com.bmo_genc.dto.DepartmentDTO;
import com.bmo_genc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO createdDepartment = departmentService.addDepartment(departmentDTO);
        return ResponseEntity.ok(createdDepartment);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
}
