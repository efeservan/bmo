package com.bmo_genc.controller;

import com.bmo_genc.dto.MentorDTO;
import com.bmo_genc.service.MentorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentor")
public class MentorController {

    private final MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @PostMapping("/add")
    public ResponseEntity<MentorDTO> addMentor(@RequestBody MentorDTO mentorDTO) {
        MentorDTO createdMentorDTO = mentorService.addMentor(mentorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMentorDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MentorDTO>> getAllMentors() {
        List<MentorDTO> mentors = mentorService.getAllMentors();
        return ResponseEntity.status(HttpStatus.OK).body(mentors);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MentorDTO> getMentorById(@PathVariable Long id) {
        MentorDTO mentorDTO = mentorService.getMentorById(id);
        return ResponseEntity.status(HttpStatus.OK).body(mentorDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MentorDTO> updateMentor(@PathVariable Long id, @RequestBody MentorDTO mentorDTO) {
        MentorDTO mentorDTOUpdated = mentorService.updateMentor(id, mentorDTO);
        return ResponseEntity.status(HttpStatus.OK).body(mentorDTOUpdated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMentor(@PathVariable Long id) {
        mentorService.deleteMentor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
