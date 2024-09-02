package com.bmo_genc.mapper;

import com.bmo_genc.dto.UniversityDTO;
import com.bmo_genc.model.University;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UniversityMapper {

    @Mapping(source = "universityName", target = "universityName")
    University toUniversity(UniversityDTO universityDTO);

    @Mapping(source = "universityName", target = "universityName")
    UniversityDTO toUniversityDTO(University university);
}
