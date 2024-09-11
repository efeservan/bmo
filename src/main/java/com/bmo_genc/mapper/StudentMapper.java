package com.bmo_genc.mapper;

import com.bmo_genc.dto.StudentDTO;
import com.bmo_genc.model.Mentor;
import com.bmo_genc.model.Student;
import com.bmo_genc.model.University;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "universityName", target = "university.universityName")
    @Mapping(source = "mentorName", target = "mentor.fullName")
    Student toStudent(StudentDTO studentDTO);

    @Mapping(source = "university.universityName", target = "universityName")
    @Mapping(source = "mentor.fullName", target= "mentorName")
    StudentDTO toStudentDTO(Student student);

    // String'ten University'ye dönüştürme
    default University mapUniversityFromString(String universityName) {
        if (universityName == null) {
            return null;
        }
        University university = new University();
        university.setUniversityName(universityName);
        return university;
    }

    // University'den String'e dönüştürme
    default String mapUniversityToString(University university) {
        if (university == null) {
            return null;
        }
        return university.getUniversityName();
    }

    // String'ten Mentor'a dönüştürme
    default Mentor mapMentorFromString(String fullName) {
        if (fullName == null) {
            return null;
        }
        Mentor mentor = new Mentor();
        mentor.setFullName(fullName);
        return mentor;
    }

    // Mentor'dan String'e dönüştürme
    default String mapMentorToString(Mentor mentor) {
        if (mentor == null) {
            return null;
        }
        return mentor.getFullName();
    }
}

