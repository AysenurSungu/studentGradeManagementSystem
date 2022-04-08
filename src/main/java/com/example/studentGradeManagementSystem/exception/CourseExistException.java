package com.example.studentGradeManagementSystem.exception;

public class CourseExistException extends RuntimeException{
    private String messageId;

    public CourseExistException(String message, String messageId) {
        super(message);
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
    }

}
