package com.example.studentGradeManagementSystem.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schoolYears")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SchoolYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String years;
    private String yearStatus;
    @Column(nullable = false, unique = true, length = 10)
    private String yearCode;




}
