package com.example.practice.exception;

public enum ErrorCode {
    EMPLOYEE_NOT_FOUND(1001, "Employee not found"),
    NULL_PAYLOAD_FIRSTNAME(1002, "Firstname cannot be null or empty!"),
    NULL_PAYLOAD_LASTNAME(1003, "Lastname cannot be null or empty!"),
    NULL_PAYLOAD_EMAIL(1004, "Email cannot be null or empty!"),
    NULL_PAYLOAD(1005, "Firstname, Lastname, Email cannot be null or empty!"),
    ID_INCLUDED(1006, "ID cannot be included in the payload!"),;

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
