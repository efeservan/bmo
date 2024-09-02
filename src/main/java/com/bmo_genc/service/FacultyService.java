package com.bmo_genc.service;

import com.bmo_genc.dto.FacultyDTO;
import com.bmo_genc.mapper.FacultyMapper;
import com.bmo_genc.model.Faculty;
import com.bmo_genc.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
//@AllArgsConstructor
public class FacultyService {

    private final FacultyRepository facultyRepository;

    private final FacultyMapper facultyMapper;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository, FacultyMapper facultyMapper) {
        this.facultyRepository = facultyRepository;
        this.facultyMapper = facultyMapper;
    }

    public FacultyDTO createFaculty(FacultyDTO facultyDTO) {
        // DTO'dan Faculty nesnesini oluştur
        Faculty faculty = facultyMapper.toFaculty(facultyDTO);

        // Faculty ve Department nesnelerini kaydet
        Faculty savedFaculty = facultyRepository.save(faculty);

        // Kaydedilen Faculty nesnesini DTO'ya dönüştür
        return facultyMapper.toFacultyDTO(savedFaculty);
    }

    public FacultyDTO getFacultyById(Long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Faculty with ID " + id + " not found"));
        return facultyMapper.toFacultyDTO(faculty);
    }

    public List<FacultyDTO> getAllFaculties() {
        List<Faculty> faculties = facultyRepository.findAll();
        return faculties.stream()
                .map(facultyMapper::toFacultyDTO)
                .toList();
    }

    public FacultyDTO updateFaculty(Long id, FacultyDTO facultyDTO) {
        // Mevcut fakülteyi veritabanından bul
        Faculty existingFaculty = facultyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Faculty with ID " + id + " not found"));
        //Departmanları güncelle
        existingFaculty.setFacultyName(facultyDTO.getFacultyName());
        // Güncellenmiş fakülteyi kaydet
        Faculty updatedFaculty = facultyRepository.save(existingFaculty);
        // DTO'ya dönüştür ve döndür
        return facultyMapper.toFacultyDTO(updatedFaculty);
    }

    public void deleteFaculty(Long id) {
        if (!facultyRepository.existsById(id)) {
            throw new NoSuchElementException("Faculty with ID " + id + " not found");
        }
        facultyRepository.deleteById(id);
    }
}
