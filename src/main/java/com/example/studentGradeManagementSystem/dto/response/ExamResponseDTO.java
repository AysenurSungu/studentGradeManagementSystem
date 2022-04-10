package com.example.studentGradeManagementSystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamResponseDTO {
    private Long examId;
    private Long studentId;
    private Long courseId;
    private Long yearId;
    private Integer score;


}
