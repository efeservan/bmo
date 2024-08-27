package com.example.bmo_genc.service;

import com.example.bmo_genc.dto.StudentDTO;
import com.example.bmo_genc.dto.UniversityDTO;
import com.example.bmo_genc.mapper.StudentMapper;
import com.example.bmo_genc.model.Student;
import com.example.bmo_genc.model.University;
import com.example.bmo_genc.repository.StudentRepository;
import com.example.bmo_genc.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private StudentMapper studentMapper;

    public StudentDTO addStudent(StudentDTO studentDTO) {
        // Üniversiteyi adından bul veya yeni bir tane oluştur
        Optional<University> universityOpt = universityRepository.findByUniversityName(studentDTO.getUniversity().getUniversityName());
        University university = universityOpt.orElseGet(() -> {
            University newUniversity = new University();
            newUniversity.setUniversityName(studentDTO.getUniversity().getUniversityName());
            return universityRepository.save(newUniversity);
        });

        // StudentDTO'yu Student nesnesine dönüştür
        Student student = studentMapper.toStudent(studentDTO);

        // Üniversiteyi atıyoruz
        student.setUniversity(university);

        // Öğrenciyi kaydediyoruz
        Student savedStudent = studentRepository.save(student);

        // Kaydedilen öğrenciyi DTO'ya çevirip dönüyoruz
        return studentMapper.toStudentDTO(savedStudent);
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::toStudentDTO)
                .collect(Collectors.toList());
    }

    private StudentDTO toStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();

        // Basit alanları mapliyoruz
        studentDTO.setTcNo(student.getTcNo());
        studentDTO.setName(student.getName());

        // University dönüşümü
        if (student.getUniversity() != null) {
            UniversityDTO universityDTO = new UniversityDTO();
            universityDTO.setUniversityName(student.getUniversity().getUniversityName());
            studentDTO.setUniversity(universityDTO);
        }

        return studentDTO;
    }
}

