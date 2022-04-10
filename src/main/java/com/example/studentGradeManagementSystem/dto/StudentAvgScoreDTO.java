package com.example.studentGradeManagementSystem.dto;

import lombok.Data;

@Data
public class StudentAvgScoreDTO {
    private Long studentId;
    private String schoolNumber;
    private String studentFullname;
    private String courseName;
    private String year;
    private Double averageScore;

}
