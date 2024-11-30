package com.rak.userservice.exceptions;

import lombok.Getter;

@Getter
public class TokenNotFoundException extends Exception{
    private final int errorCode;
    public TokenNotFoundException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
