package com.example.studentGradeManagementSystem.repository;

import com.example.studentGradeManagementSystem.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
