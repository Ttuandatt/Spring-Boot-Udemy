package com.example.practice.exception;

public enum ErrorCode {
    EMPLOYEE_NOT_FOUND(1001, "Employee not found"),
    NULL_PAYLOAD(1002, "Payload cannot be null or empty!"),;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
