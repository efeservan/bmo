package com.bmo_genc.repository;

import com.bmo_genc.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
    Optional<Mentor> findByFullName(String fullName);
}
