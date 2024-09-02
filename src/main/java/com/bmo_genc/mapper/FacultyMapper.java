package com.bmo_genc.mapper;

import com.bmo_genc.dto.FacultyDTO;
import com.bmo_genc.model.Faculty;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacultyMapper {

    Faculty toFaculty(FacultyDTO facultyDTO);

    FacultyDTO toFacultyDTO(Faculty faculty);

}
