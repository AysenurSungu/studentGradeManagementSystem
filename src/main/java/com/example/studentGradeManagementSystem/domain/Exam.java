package com.example.studentGradeManagementSystem.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "exams")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotBlank
    @Column
    private Integer score;


}
