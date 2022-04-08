package com.example.studentGradeManagementSystem.service;

import com.example.studentGradeManagementSystem.domain.Exam;
import com.example.studentGradeManagementSystem.domain.SchoolYear;

public interface ExamService {
    Exam createExam(Exam exam);

    SchoolYear createYear(SchoolYear schoolYear);
}
