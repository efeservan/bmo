package com.example.bmo_genc.mapper;

import com.example.bmo_genc.dto.UniversityDTO;
import com.example.bmo_genc.model.University;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UniversityMapper {

    @Mapping(source = "universityName", target = "universityName")
    University toUniversity(UniversityDTO universityDTO);

    @Mapping(source = "universityName", target = "universityName")
    UniversityDTO toUniversityDTO(University university);
}
