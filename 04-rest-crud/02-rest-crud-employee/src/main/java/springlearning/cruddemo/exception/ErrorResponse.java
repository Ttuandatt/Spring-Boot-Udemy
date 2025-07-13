package springlearning.cruddemo.exception;

import java.sql.Time;

public class ErrorResponse {
    private int status;
    private String message;
    private Time timeStamp;

    public ErrorResponse() {
    }

    public ErrorResponse(int status, String message, Time timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Time getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Time timeStamp) {
        this.timeStamp = timeStamp;
    }


}
