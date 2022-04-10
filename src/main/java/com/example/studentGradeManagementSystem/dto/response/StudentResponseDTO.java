package com.example.studentGradeManagementSystem.dto.response;

import com.example.studentGradeManagementSystem.domain.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {
    private Long id;
    private String schoolNumber;
    private String fullname;
    private List<Course> courses;

}
