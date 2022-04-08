package com.example.studentGradeManagementSystem.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;

    @NotBlank
    @Column(nullable = false, unique = true, length = 10)
    private String courseCode;

    @NotBlank
    @Column(nullable = false, unique = true, length = 40)
    private String courseName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "examId", nullable = false)
    private List<Exam> courseExams;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CourseStatus status;

    @NotBlank
    @Column(nullable = false)
    private String score;

}
