package com.bmo_genc.mapper;

import com.bmo_genc.dto.DepartmentDTO;
import com.bmo_genc.model.Department;
import com.bmo_genc.model.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(source = "faculty.id", target = "facultyId")
    DepartmentDTO toDepartmentDTO(Department department);

    @Mapping(source = "facultyId", target = "faculty.id")
    Department toDepartment(DepartmentDTO departmentDTO);

    // id'den Faculty'ye dönüştürme
    default Faculty map(Long facultyId) {
        if (facultyId == null) {
            return null;
        }
        Faculty faculty = new Faculty();
        faculty.setId(facultyId);
        return faculty;
    }

    default Long map(Faculty faculty) {
        if (faculty == null) {
            return null;
        }
        return faculty.getId();
    }
}
