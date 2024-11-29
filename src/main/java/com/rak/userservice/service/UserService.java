package com.rak.userservice.service;

import com.rak.userservice.dtos.LoginRequestDto;
import com.rak.userservice.dtos.SignupRequestDto;
import com.rak.userservice.dtos.UserResponseDto;
import com.rak.userservice.models.Token;
import com.rak.userservice.models.User;
import com.rak.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto signup(SignupRequestDto signupRequestDto) {
        User user = new User();
        user.setName(signupRequestDto.getName());
        user.setEmail(signupRequestDto.getEmail());
        user.setHashedPassword(signupRequestDto.getPassword());
        return null;
    }

    public Token login(LoginRequestDto loginRequestDto) {
        return null;
    }

    public UserResponseDto validateToken(String token) {
        return null;
    }

    // public UserResponseDto create()

}
