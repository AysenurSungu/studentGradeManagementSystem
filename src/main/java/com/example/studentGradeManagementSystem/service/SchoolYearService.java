package com.example.studentGradeManagementSystem.service;

import com.example.studentGradeManagementSystem.domain.SchoolYear;

public interface SchoolYearService {
    SchoolYear addYear(SchoolYear schoolYear);
    SchoolYear getYearCode(String yearCode);
}
