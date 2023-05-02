package com.example.StudentJpaMapping.controller;

import com.example.StudentJpaMapping.entity.Course;
import com.example.StudentJpaMapping.entity.Student;
import com.example.StudentJpaMapping.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // existing methods

    @GetMapping("/{id}/students")
    public ResponseEntity<List<Student>> getStudentsEnrolledInCourse(@PathVariable Long id) {
        List<Student> students = courseService.getStudentsEnrolledInCourse(id);
        return ResponseEntity.ok(students);
    }
        @GetMapping("/{courseId}/institution/{institutionId}/students")
        public ResponseEntity<List<Student>> getStudentsEnrolledInCourseFromInstitution(
                @PathVariable Long courseId,
                @PathVariable Long institutionId) {
            List<Student> students = courseService.getStudentsEnrolledInCourseFromInstitution(courseId, institutionId);
            return ResponseEntity.ok(students);

    }


    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course newCourse = courseService.createCourse(course);
        return ResponseEntity.ok(newCourse);
    }
}
