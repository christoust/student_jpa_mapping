package com.example.StudentJpaMapping.repository;

import com.example.StudentJpaMapping.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution,Long> {
}
