package com.example.studentGradeManagementSystem.service;


import com.example.studentGradeManagementSystem.domain.Course;
import com.example.studentGradeManagementSystem.domain.Student;
import com.example.studentGradeManagementSystem.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);
    List<StudentDTO> findAllStudents();

    Student addCourse(Course course, Student student);
}
