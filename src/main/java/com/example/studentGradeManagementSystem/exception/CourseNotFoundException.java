package com.example.studentGradeManagementSystem.exception;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(String message) {
        super(message);
    }

}
