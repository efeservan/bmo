package com.example.bmo_genc.mapper;

import com.example.bmo_genc.dto.StudentDTO;
import com.example.bmo_genc.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    //@Mapping(source = "universityName", target = "university.universityName")
    Student toStudent(StudentDTO studentDTO);

//    @Mapping(source = "university.universityName", target = "universityName")
    StudentDTO toStudentDTO(Student student);

//    University toUniversity(String universityName);

}
