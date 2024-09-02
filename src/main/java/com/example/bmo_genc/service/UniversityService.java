package com.example.bmo_genc.service;

import com.example.bmo_genc.dto.UniversityDTO;
import com.example.bmo_genc.mapper.UniversityMapper;
import com.example.bmo_genc.model.University;
import com.example.bmo_genc.repository.UniversityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class UniversityService {

    @Autowired
    private final UniversityRepository universityRepository;

    @Autowired
    private final UniversityMapper universityMapper;

    public UniversityService(UniversityRepository universityRepository, UniversityMapper universityMapper) {
        this.universityRepository = universityRepository;
        this.universityMapper = universityMapper;
    }

    public UniversityDTO addUniversity(UniversityDTO universityDTO){
        University tempUniversity = universityMapper.toUniversity(universityDTO);
        University savedUniversity = universityRepository.save(tempUniversity);
        return universityMapper.toUniversityDTO(savedUniversity);
    }

    public UniversityDTO getUniversity(Long id){
        University searchingUniversity = universityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("University with ID " + id + " not found"));

        return universityMapper.toUniversityDTO(searchingUniversity);
    }

    public List<UniversityDTO> getAllUniversities(){
        return universityRepository.findAll().stream()
                .map(universityMapper::toUniversityDTO)
                .collect(Collectors.toList());
    }

    public UniversityDTO updateUniversity(Long id, UniversityDTO universityDTO){
        University existingUniversity = universityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("University with ID " + id + " not found"));

        existingUniversity.setUniversityName(universityDTO.getUniversityName());

        University updatedUniversity = universityRepository.save(existingUniversity);

        return universityMapper.toUniversityDTO(updatedUniversity);
    }

    public void deleteUniversity(Long id){
        University deletedUniversity = universityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("University with ID " + id + " not found"));

        universityRepository.delete(deletedUniversity);
    }

}
