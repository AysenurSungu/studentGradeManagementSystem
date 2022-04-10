package com.example.studentGradeManagementSystem.exception;

public class StudentNotFoundException extends RuntimeException{
    private Long messageId;
    public StudentNotFoundException(String message, Long messageId) {
        super(message);
        this.messageId=messageId;
    }
    public Long getMessageId() {return messageId;}
}
