package com.example.studentGradeManagementSystem.service;

import com.example.studentGradeManagementSystem.domain.Student;
import com.example.studentGradeManagementSystem.dto.StudentAvgScoreDTO;
import com.example.studentGradeManagementSystem.dto.request.StudentRequestDTO;
import com.example.studentGradeManagementSystem.dto.response.StudentResponseDTO;

import java.util.List;

public interface StudentService {

    StudentResponseDTO addStudent(StudentRequestDTO studentRequest);
    StudentResponseDTO getStudentById(Long studentId);
    List<StudentResponseDTO> getStudents();

    Student getStudent(Long studentId);

    List<StudentAvgScoreDTO> getCourseAndExamsByStudentId(Long studentId);
}
