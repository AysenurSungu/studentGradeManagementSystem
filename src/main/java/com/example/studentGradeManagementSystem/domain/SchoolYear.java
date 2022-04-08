package com.example.studentGradeManagementSystem.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "schoolYears")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class SchoolYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String yearId;

    @Enumerated(EnumType.STRING)
    @NotNull
    private YearStatus yearStatus;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String years;


}
