package com.rak.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundMessageDto {
    private int errorCode;
    private String message;
}
