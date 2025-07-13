package springlearning.cruddemo.exception;

public enum ErrorCode {
    EMPLOYEE_NOT_FOUND(1001, "Employee not found"),
    INVALID_FIRST_NAME(1002, "Invalid first name. First name cannot be empty or null, must contain at least 3 characters, and no number!."),
    INVALID_LAST_NAME(1003, "Invalid last name. Last name cannot be empty or null, must contain at least 3 characters, and no number!."),
    INVALID_EMAIL(1004, "Invalid email. Email cannot be empty or null!"),
    NULL_PAYLOAD(1005, "Payload cannot be null or empty!"),;

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
