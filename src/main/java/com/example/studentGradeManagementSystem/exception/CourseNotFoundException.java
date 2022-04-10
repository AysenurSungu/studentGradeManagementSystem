package com.example.studentGradeManagementSystem.exception;

public class CourseNotFoundException extends RuntimeException{
    private Long messageId;

    public CourseNotFoundException(String message, Long courseId) {
    }

    public Long getMessageId() {
        return messageId;
    }
}
