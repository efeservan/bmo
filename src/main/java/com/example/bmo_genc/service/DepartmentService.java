package com.example.bmo_genc.service;

import com.example.bmo_genc.dto.DepartmentDTO;
import com.example.bmo_genc.mapper.DepartmentMapper;
import com.example.bmo_genc.model.Department;
import com.example.bmo_genc.model.Faculty;
import com.example.bmo_genc.repository.DepartmentRepository;
import com.example.bmo_genc.repository.FacultyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private DepartmentMapper departmentMapper;

    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        Faculty faculty = facultyRepository.findById(departmentDTO.getFacultyId())
                .orElseThrow(() -> new EntityNotFoundException("Faculty not found"));

        Department department = departmentMapper.toDepartment(departmentDTO);
        department.setFaculty(faculty);

        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDepartmentDTO(savedDepartment);
    }

    public List<DepartmentDTO> getAllDepartments(){
        return departmentRepository.findAll().stream()
                .map(departmentMapper::toDepartmentDTO)
                .collect(Collectors.toList());
    }
}
