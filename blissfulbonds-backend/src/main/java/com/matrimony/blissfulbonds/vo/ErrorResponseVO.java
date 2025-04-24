package com.matrimony.blissfulbonds.vo;

import java.time.LocalDateTime;

public class ErrorResponseVO {
    private LocalDateTime timeStamp;
    private String message;
    private int errorCode;

    public ErrorResponseVO(LocalDateTime timeStamp, String message, int errorCode) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.errorCode = errorCode;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
