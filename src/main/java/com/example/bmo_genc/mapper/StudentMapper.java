package com.example.bmo_genc.mapper;

import com.example.bmo_genc.dto.StudentDTO;
import com.example.bmo_genc.model.Student;
import com.example.bmo_genc.model.University;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "universityName", target = "university")
    Student toStudent(StudentDTO studentDTO);

    @Mapping(source = "university.universityName", target = "universityName")
    StudentDTO toStudentDTO(Student student);

    // String'ten University'ye dönüştürme
    default University map(String universityName) {
        if (universityName == null) {
            return null;
        }
        University university = new University();
        university.setUniversityName(universityName);
        return university;
    }

    // University'den String'e dönüştürme
    default String map(University university) {
        if (university == null) {
            return null;
        }
        return university.getUniversityName();
    }
}

