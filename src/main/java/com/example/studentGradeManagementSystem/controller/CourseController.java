package com.example.studentGradeManagementSystem.controller;

import com.example.studentGradeManagementSystem.domain.Course;

import com.example.studentGradeManagementSystem.dto.CourseDTO;
import com.example.studentGradeManagementSystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@CrossOrigin
@RequestScope
@RequestMapping("/courses")
@RequiredArgsConstructor
@Validated
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return ResponseEntity.ok(courseService.createCourse(course));
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAllCourses(){
        return ResponseEntity.ok(courseService.findAllCourses());
    }
}
