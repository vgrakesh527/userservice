package com.rak.userservice.exceptions;

import com.rak.userservice.dtos.TokenNotFoundMessageDto;
import com.rak.userservice.dtos.UserNotFoundMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<UserNotFoundMessageDto> userNotFoundMessage(UserNotFoundException userNotFoundException) {
        UserNotFoundMessageDto userNotFoundMessageDto = new UserNotFoundMessageDto();
        userNotFoundMessageDto.setErrorCode(userNotFoundException.getErrorCode());
        userNotFoundMessageDto.setMessage(userNotFoundException.getMessage());
        return new ResponseEntity<>(userNotFoundMessageDto, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<TokenNotFoundMessageDto> tokenNotFoundMessage(TokenNotFoundException tokenNotFoundException) {
        TokenNotFoundMessageDto tokenNotFoundMessageDto = new TokenNotFoundMessageDto();
        tokenNotFoundMessageDto.setErrorCode(tokenNotFoundException.getErrorCode());
        tokenNotFoundMessageDto.setMessage(tokenNotFoundException.getMessage());
        return new ResponseEntity<>(tokenNotFoundMessageDto, HttpStatus.NOT_FOUND);

    }
}
