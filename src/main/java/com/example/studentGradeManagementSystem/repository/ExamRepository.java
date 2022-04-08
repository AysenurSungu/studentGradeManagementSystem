package com.example.studentGradeManagementSystem.repository;

import com.example.studentGradeManagementSystem.domain.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, String> {
}
