package com.rak.userservice.services;

import com.rak.userservice.dtos.TokenResponseDto;
import com.rak.userservice.exceptions.TokenNotFoundException;
import com.rak.userservice.models.Token;
import com.rak.userservice.repository.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenService {
    private TokenRepository tokenRepository;

    public TokenResponseDto save(Token token) {
        return TokenResponseDto.fromToken(tokenRepository.save(token));
    }

    public TokenResponseDto validateToken(String token) throws TokenNotFoundException {
        var myToken  = tokenRepository.findByValue(token);
        if(myToken == null){
            throw new TokenNotFoundException(444, "Token not found");
        }
        return TokenResponseDto.fromToken(myToken);
    }
}
