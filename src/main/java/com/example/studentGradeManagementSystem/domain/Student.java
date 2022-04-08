package com.example.studentGradeManagementSystem.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String studentId;

    @NotBlank
    @Column(nullable = false, unique = true, length = 11)
    private String schoolNumber;

    @NotBlank
    @Column(nullable = false, length = 40)
    private String fullname;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private List<Course> takenCourses;


}
