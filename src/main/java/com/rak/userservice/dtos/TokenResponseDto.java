package com.rak.userservice.dtos;

import com.rak.userservice.models.Token;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponseDto {
    private String token;
    private boolean expired;
    private UserResponseDto user;

    public static TokenResponseDto fromToken(Token token) {
        TokenResponseDto dto = new TokenResponseDto();
        dto.setToken(token.getValue());
        dto.setExpired(token.isDeleted());
        dto.setUser(UserResponseDto.from(token.getUser()));
        return dto;
    }
}
