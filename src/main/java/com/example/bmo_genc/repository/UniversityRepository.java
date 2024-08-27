package com.example.bmo_genc.repository;

import com.example.bmo_genc.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

    Optional<University> findByUniversityName(String universityName);
}
