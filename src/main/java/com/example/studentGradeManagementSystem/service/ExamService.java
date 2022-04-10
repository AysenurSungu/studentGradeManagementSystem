package com.example.studentGradeManagementSystem.service;

import com.example.studentGradeManagementSystem.domain.Exam;
import com.example.studentGradeManagementSystem.dto.request.ExamRequestDTO;
import com.example.studentGradeManagementSystem.dto.response.ExamResponseDTO;

import java.util.List;

public interface ExamService {
    ExamResponseDTO addExam(ExamRequestDTO examRequest);

    List<Exam> getAllExams();

    List<Exam> getAllExamsOfStudent(Long studentId);
}
