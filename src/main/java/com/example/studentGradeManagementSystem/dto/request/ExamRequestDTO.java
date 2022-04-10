package com.example.studentGradeManagementSystem.dto.request;

import com.example.studentGradeManagementSystem.domain.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamRequestDTO {

    private Long examId;
    private Long studentId;
    private Course course;
    private Long yearId;
    private Integer score;
}
