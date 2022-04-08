package com.example.studentGradeManagementSystem.repository;

import com.example.studentGradeManagementSystem.domain.SchoolYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolYearRepository extends JpaRepository<SchoolYear, String> {
}
