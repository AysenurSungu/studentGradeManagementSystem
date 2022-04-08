package com.example.studentGradeManagementSystem.controller;

import com.example.studentGradeManagementSystem.domain.Course;
import com.example.studentGradeManagementSystem.domain.Student;
import com.example.studentGradeManagementSystem.dto.StudentDTO;
import com.example.studentGradeManagementSystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@CrossOrigin
@RequestScope
@RequestMapping("/students")
@RequiredArgsConstructor
@Validated
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAllStudents(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @PatchMapping
    public ResponseEntity<Student> addCourse(@RequestBody Course course,
                                             @RequestBody Student student){
        return ResponseEntity.ok(studentService.addCourse(course, student));
    }

}
