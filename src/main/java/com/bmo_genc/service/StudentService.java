package com.bmo_genc.service;

import com.bmo_genc.dto.StudentDTO;
import com.bmo_genc.mapper.StudentMapper;
import com.bmo_genc.model.Student;
import com.bmo_genc.model.University;
import com.bmo_genc.repository.StudentRepository;
import com.bmo_genc.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;
    private final StudentMapper studentMapper;
    private final ExecutorService executorService;

    @Autowired
    public StudentService(StudentRepository studentRepository, UniversityRepository universityRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.universityRepository = universityRepository;
        this.studentMapper = studentMapper;
        // Thread havuzunu burada oluşturuyoruz
        this.executorService = Executors.newFixedThreadPool(5);
    }

    // Asenkron öğrenci kaydetme işlemi
    public void addStudentAsync(StudentDTO studentDTO) {
        executorService.submit(() -> addStudent(studentDTO)); // Metodu arka planda çalıştır.
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        University university = findOrCreateUniversity(studentDTO.getUniversityName());

        Student student = studentMapper.toStudent(studentDTO);
        student.setUniversity(university);

        Student savedStudent = studentRepository.save(student);
        return studentMapper.toStudentDTO(savedStudent);
    }

    public StudentDTO updateStudent(StudentDTO studentDTO) {
        Long studentId = studentDTO.getId();
        if (studentId == null) {
            throw new IllegalArgumentException("Student ID cannot be null");
        }

        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("Student with ID " + studentId + " not found"));

        // Güncellenmiş bilgileri mevcut öğrenciye aktar
        updateStudentInfo(existingStudent, studentDTO);

        University university = findOrCreateUniversity(studentDTO.getUniversityName());
        existingStudent.setUniversity(university);

        Student updatedStudent = studentRepository.save(existingStudent);
        return studentMapper.toStudentDTO(updatedStudent);
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO findStudentById(Long id) {
        Student searchingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student with ID " + id + " not found"));
        return studentMapper.toStudentDTO(searchingStudent);
    }

    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student with ID " + id + " not found");
        }
        studentRepository.deleteById(id);
    }

    private University findOrCreateUniversity(String universityName) {
        return universityRepository.findByUniversityName(universityName)
                .orElseGet(() -> {
                    University newUniversity = new University();
                    newUniversity.setUniversityName(universityName);
                    return universityRepository.save(newUniversity);
                });
    }

    private void updateStudentInfo(Student existingStudent, StudentDTO studentDTO) {
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
    }
}
