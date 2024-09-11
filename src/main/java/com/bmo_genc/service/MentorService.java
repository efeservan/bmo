package com.bmo_genc.service;

import com.bmo_genc.dto.MentorDTO;
import com.bmo_genc.mapper.MentorMapper;
import com.bmo_genc.mapper.StudentMapper;
import com.bmo_genc.model.Mentor;
import com.bmo_genc.model.University;
import com.bmo_genc.repository.MentorRepository;
import com.bmo_genc.repository.StudentRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;
    private final MentorMapper mentorMapper;

    @Autowired
    public MentorService(MentorRepository mentorRepository, MentorMapper mentorMapper) {
        this.mentorRepository = mentorRepository;
        this.mentorMapper = mentorMapper;
    }

    public MentorDTO addMentor(MentorDTO mentorDTO) {
        Mentor tempMentor = mentorMapper.toMentor(mentorDTO);
        Mentor savedMentor = mentorRepository.save(tempMentor);
        return mentorMapper.toMentorDTO(savedMentor);
    }

    public List<MentorDTO> getAllMentors() {
        return mentorRepository.findAll().stream()
                .map(mentorMapper::toMentorDTO)
                .collect(Collectors.toList());
    }

    public MentorDTO getMentorById(Long id) {
        return mentorMapper.toMentorDTO(mentorRepository.findById(id).orElse(null));
    }

    public MentorDTO updateMentor(Long id, MentorDTO mentorDTO) {
        Mentor existingMentor = mentorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Mentor with ID " + id + " not found"));

        existingMentor.setFullName(mentorDTO.getFullName());

        Mentor updatedMentor = mentorRepository.save(existingMentor);
        return mentorMapper.toMentorDTO(updatedMentor);
    }

    public void deleteMentor(Long id) {
        Mentor deletedMentor = mentorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Mentor with ID " + id + " not found"));

        mentorRepository.delete(deletedMentor);
    }
}
