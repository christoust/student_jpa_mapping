package com.example.StudentJpaMapping.service;

import com.example.StudentJpaMapping.entity.Course;
import com.example.StudentJpaMapping.entity.Institution;
import com.example.StudentJpaMapping.entity.Student;
import com.example.StudentJpaMapping.repository.CourseRepository;
import com.example.StudentJpaMapping.repository.InstitutionRepository;
import com.example.StudentJpaMapping.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private InstitutionRepository institutionRepository;
    @Autowired
    private StudentRepository studentRepository;


    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(null);
    }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }





    // existing methods

    public List<Student> getStudentsEnrolledInCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        return course.getStudents();
    }
    public List<Student> getStudentsEnrolledInCourseFromInstitution(Long courseId, Long institutionId) {
        Institution institution = institutionRepository.findById(institutionId)
                .orElseThrow(null);
        Course course = courseRepository.findById(courseId)
                .orElseThrow(null);

//        if (!institution.getCourses().contains(course)) {
//            throw new BadRequestException("Institution " + institutionId + " does not offer course " + courseId);
//        }

        List<Student> students = studentRepository.findByInstitutionAndCourses(institution, course);
        return students;
    }

}
