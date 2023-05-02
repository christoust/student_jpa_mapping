package com.example.StudentJpaMapping.repository;

import com.example.StudentJpaMapping.entity.Course;
import com.example.StudentJpaMapping.entity.Institution;
import com.example.StudentJpaMapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByInstitutionAndCourses(Institution institution, Course course);
}
