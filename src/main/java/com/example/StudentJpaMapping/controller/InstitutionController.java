package com.example.StudentJpaMapping.controller;

import com.example.StudentJpaMapping.entity.Institution;
import com.example.StudentJpaMapping.entity.Student;
import com.example.StudentJpaMapping.service.CourseService;
import com.example.StudentJpaMapping.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/institutions")
public class InstitutionController {

    @Autowired
    private InstitutionService institutionService;

    @GetMapping
    public ResponseEntity<List<Institution>> getAllInstitutions() {
        List<Institution> institutions = institutionService.getAllInstitutions();
        return ResponseEntity.ok(institutions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institution> getInstitutionById(@PathVariable Long id) {
        Institution institution = institutionService.getInstitutionById(id);
        return ResponseEntity.ok(institution);
    }

    @PostMapping
    public ResponseEntity<Institution> addInstitution(@RequestBody Institution institution) {
        Institution newInstitution = institutionService.addInstitution(institution);
        return ResponseEntity.ok(newInstitution);
    }
}
