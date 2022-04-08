package com.example.studentGradeManagementSystem.controller;

import com.example.studentGradeManagementSystem.domain.Exam;
import com.example.studentGradeManagementSystem.domain.SchoolYear;
import com.example.studentGradeManagementSystem.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@CrossOrigin
@RequestScope
@RequestMapping("/exams")
@RequiredArgsConstructor
@Validated
public class ExamController {
    private final ExamService examService;

    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam){
        return ResponseEntity.ok(examService.createExam(exam));
    }

    @PostMapping("/addyear")
    public ResponseEntity<SchoolYear> createYear(@RequestBody SchoolYear schoolYear){
        return ResponseEntity.ok(examService.createYear(schoolYear));
    }
}
