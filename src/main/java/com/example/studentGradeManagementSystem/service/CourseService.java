package com.example.studentGradeManagementSystem.service;

import com.example.studentGradeManagementSystem.domain.Course;
import com.example.studentGradeManagementSystem.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);

    List<CourseDTO> findAllCourses();
}
