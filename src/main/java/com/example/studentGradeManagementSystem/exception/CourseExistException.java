package com.example.studentGradeManagementSystem.exception;

public class CourseExistException extends RuntimeException{
    private Long messageId;

    public CourseExistException(String message, Long messageId) {
        super(message);
        this.messageId = messageId;
    }

    public Long getMessageId() {
        return messageId;
    }

}
