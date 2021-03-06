package com.globallogic.PersonDemo.CustomException;


import org.springframework.stereotype.Component;

@Component
public class ServiceException extends RuntimeException{

    private String errorCode;
    private String errorMessage;

    public ServiceException() {
    }

    public ServiceException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
