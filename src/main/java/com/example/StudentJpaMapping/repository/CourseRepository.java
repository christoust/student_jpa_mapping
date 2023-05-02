package com.example.StudentJpaMapping.repository;

import com.example.StudentJpaMapping.entity.Course;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
