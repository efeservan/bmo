package com.example.bmo_genc.service;

import com.example.bmo_genc.model.Department;
import com.example.bmo_genc.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

//    @Autowired
//    private FacultyRepository facultyRepository;

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
}
