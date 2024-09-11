package com.bmo_genc.mapper;

import com.bmo_genc.dto.MentorDTO;
import com.bmo_genc.model.Mentor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MentorMapper {

    Mentor toMentor(MentorDTO mentorDTO);

    MentorDTO toMentorDTO(Mentor mentor);
}
