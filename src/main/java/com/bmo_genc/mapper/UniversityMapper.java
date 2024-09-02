package com.bmo_genc.mapper;

import com.bmo_genc.dto.UniversityDTO;
import com.bmo_genc.model.University;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UniversityMapper {

    University toUniversity(UniversityDTO universityDTO);

    UniversityDTO toUniversityDTO(University university);
}
