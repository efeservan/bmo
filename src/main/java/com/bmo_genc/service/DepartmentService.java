package com.bmo_genc.service;

import com.bmo_genc.dto.DepartmentDTO;
import com.bmo_genc.mapper.DepartmentMapper;
import com.bmo_genc.model.Department;
import com.bmo_genc.model.Faculty;
import com.bmo_genc.repository.DepartmentRepository;
import com.bmo_genc.repository.FacultyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, FacultyRepository facultyRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.facultyRepository = facultyRepository;
        this.departmentMapper = departmentMapper;
    }

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

    public void deleteDepartment(Long id) {
        if(!departmentRepository.existsById(id)) {
            throw new NoSuchElementException("Department with ID " + id + " not found");
        }
        departmentRepository.deleteById(id);
    }
}
