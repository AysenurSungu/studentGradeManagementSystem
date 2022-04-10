package com.example.studentGradeManagementSystem.dto.request;

import com.example.studentGradeManagementSystem.domain.Exam;
import com.example.studentGradeManagementSystem.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDTO {
    private Long id;
    private String courseCode;
    private String courseName;
    private Long yearId;
    private List<Student> students;
}
