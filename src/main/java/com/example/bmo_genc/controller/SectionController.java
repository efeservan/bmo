package com.example.bmo_genc.controller;

import com.example.bmo_genc.model.Section;
import com.example.bmo_genc.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping
    public ResponseEntity<List<Section>> getAllSections(){
        List<Section> sections = sectionService.getAllSections();
        return ResponseEntity.ok(sections);
    }
}
