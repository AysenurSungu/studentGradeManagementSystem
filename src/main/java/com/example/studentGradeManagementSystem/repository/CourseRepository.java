package com.example.studentGradeManagementSystem.repository;

import com.example.studentGradeManagementSystem.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseCode(String courseCode);
}
