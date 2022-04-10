package com.example.studentGradeManagementSystem.controller;

import com.example.studentGradeManagementSystem.service.ExamService;
import lombok.RequiredArgsConstructor;
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

}
