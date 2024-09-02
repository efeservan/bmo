package com.example.bmo_genc.service;

import com.example.bmo_genc.dto.StudentDTO;
import com.example.bmo_genc.mapper.StudentMapper;
import com.example.bmo_genc.model.Student;
import com.example.bmo_genc.model.University;
import com.example.bmo_genc.repository.StudentRepository;
import com.example.bmo_genc.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;
    private final StudentMapper studentMapper;

//    @Autowired
    public StudentService(StudentRepository studentRepository, UniversityRepository universityRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.universityRepository = universityRepository;
        this.studentMapper = studentMapper;
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        // Üniversiteyi adından bul veya yeni bir tane oluştur
        Optional<University> universityOpt = universityRepository.findByUniversityName(studentDTO.getUniversityName());
        University university = universityOpt.orElseGet(() -> {
            University newUniversity = new University();
            newUniversity.setUniversityName(studentDTO.getUniversityName());
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

    public StudentDTO updateStudent(StudentDTO studentDTO) {
        // Öğrenci ID’sini al
        Long studentId = studentDTO.getId(); // ID alanının DTO’da mevcut olduğundan emin ol

        if (studentId == null) {
            throw new IllegalArgumentException("Student ID cannot be null");
        }
        // Öğrenciyi veritabanında bul
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("Student with ID " + studentId + " not found"));

        // Güncellenmiş bilgileri mevcut öğrenciye aktar
        existingStudent.setTcNo(studentDTO.getTcNo());
        existingStudent.setName(studentDTO.getName());
        existingStudent.setSurname(studentDTO.getSurname());
        existingStudent.setEmail(studentDTO.getEmail());
        existingStudent.setFatherName(studentDTO.getFatherName());
        existingStudent.setMotherName(studentDTO.getMotherName());
        existingStudent.setHomeTown(studentDTO.getHomeTown());
        existingStudent.setBirthDate(studentDTO.getBirthDate());
        existingStudent.setCity(studentDTO.getCity());
        existingStudent.setFaculty(studentDTO.getFaculty());
        existingStudent.setDepartment(studentDTO.getDepartment());
        existingStudent.setClassDegree(studentDTO.getClassDegree());
        existingStudent.setPhoneNumber(studentDTO.getPhoneNumber());

        // Üniversiteyi güncelle veya oluştur
        University university = universityRepository.findByUniversityName(studentDTO.getUniversityName())
                .orElseGet(() -> {
                    University newUniversity = new University();
                    newUniversity.setUniversityName(studentDTO.getUniversityName());
                    return universityRepository.save(newUniversity);
                });

        existingStudent.setUniversity(university);

        // Güncellenmiş öğrenciyi kaydet
        Student updatedStudent = studentRepository.save(existingStudent);

        // DTO’ya çevirip döndür
        return studentMapper.toStudentDTO(updatedStudent);
    }

    public List<StudentDTO> getAllStudents() {
        // MapStruct ile otomatik dönüşüm
        return studentRepository.findAll().stream()
                .map(studentMapper::toStudentDTO)
                .collect(Collectors.toList());
    }
}


