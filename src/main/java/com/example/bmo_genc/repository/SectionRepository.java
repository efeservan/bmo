package com.example.bmo_genc.repository;

import com.example.bmo_genc.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository <Section, Long>{
}
