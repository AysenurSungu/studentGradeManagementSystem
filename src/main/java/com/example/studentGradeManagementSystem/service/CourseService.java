package com.example.studentGradeManagementSystem.service;

import com.example.studentGradeManagementSystem.domain.Course;
import com.example.studentGradeManagementSystem.dto.request.CourseRequestDTO;
import com.example.studentGradeManagementSystem.dto.response.CourseResponseDTO;
import com.example.studentGradeManagementSystem.dto.response.ExamResponseDTO;

import java.util.List;

public interface CourseService {

    CourseResponseDTO addCourse(CourseRequestDTO courseRequest);

    CourseResponseDTO getCourseById(Long courseId);

    Course getCourse(Long courseId);

    List<CourseResponseDTO> getCourses();

    CourseResponseDTO addStudentToCourse(Long courseId, Long studentId);

    List<CourseResponseDTO> getScoresAndAvgScore(Long studentId, String courseCode, String yearCode);

    ExamResponseDTO addExamToCourse(Long courseId, Long studentId, int examScore);
}
