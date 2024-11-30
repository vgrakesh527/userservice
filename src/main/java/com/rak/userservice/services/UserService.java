package com.rak.userservice.services;

import com.rak.userservice.dtos.LoginRequestDto;
import com.rak.userservice.dtos.SignupRequestDto;
import com.rak.userservice.dtos.TokenResponseDto;
import com.rak.userservice.dtos.UserResponseDto;
import com.rak.userservice.exceptions.TokenNotFoundException;
import com.rak.userservice.exceptions.UserNotFoundException;
import com.rak.userservice.models.Token;
import com.rak.userservice.models.User;
import com.rak.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserResponseDto signup(SignupRequestDto signupRequestDto) {
        User user = new User();
        user.setName(signupRequestDto.getName());
        user.setEmail(signupRequestDto.getEmail());
        user.setHashedPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
        return UserResponseDto.from(userRepository.save(user));
    }

    public TokenResponseDto login(LoginRequestDto loginRequestDto) throws UserNotFoundException {
        var user = userRepository.findByEmail(loginRequestDto.getEmail());
        if (user == null) {
            throw new UserNotFoundException(123, "User not found!!");
        }
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getHashedPassword())) {
            throw new UserNotFoundException(234, "Wrong password!!");
        }
        Token token = new Token();
        token.setUser(user);
        token.setValue(UUID.randomUUID().toString());
        return tokenService.save(token);
    }

    public UserResponseDto validateToken(String token) throws TokenNotFoundException {
        return tokenService.validateToken(token).getUser();
    }

    // public UserResponseDto create()

}
