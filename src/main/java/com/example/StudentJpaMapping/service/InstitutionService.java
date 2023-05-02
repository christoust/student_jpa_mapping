package com.example.StudentJpaMapping.service;

import com.example.StudentJpaMapping.entity.Institution;
import com.example.StudentJpaMapping.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    public Institution getInstitutionById(Long id) {
        return institutionRepository.findById(id)
                .orElse(null);   }

    public Institution addInstitution(Institution institution) {
        return institutionRepository.save(institution);
    }
}
