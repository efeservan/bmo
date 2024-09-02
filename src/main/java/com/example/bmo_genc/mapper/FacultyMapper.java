package com.example.bmo_genc.mapper;

import com.example.bmo_genc.dto.FacultyDTO;
import com.example.bmo_genc.model.Department;
import com.example.bmo_genc.model.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface FacultyMapper {

//    @Mapping(source = "departmentNames", target = "departments")
    Faculty toFaculty(FacultyDTO facultyDTO);

//    @Mapping(source = "departments", target = "departmentNames")
    FacultyDTO toFacultyDTO(Faculty faculty);

//    default List<String> departmentsToDepartmentNames(List<Department> departments) {
//        return departments.stream().
//                map(Department::getDepartmentName)
//                .collect(Collectors.toList());
//    }
//
//    default List<Department> departmentNamesToDepartments(List<String> departmentNames) {
//        return departmentNames.stream().map(name -> {
//            Department department = new Department();
//            department.setDepartmentName(name);
//            return department;
//        }).collect(Collectors.toList());
//    }
}
