package com.rak.userservice.exceptions;

import lombok.Getter;

@Getter
public class UserNotFoundException extends Exception{
    private final int errorCode;
    public UserNotFoundException(int errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
