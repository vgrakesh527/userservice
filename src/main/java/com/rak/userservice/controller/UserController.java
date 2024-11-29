package com.rak.userservice.controller;

import com.rak.userservice.dtos.LoginRequestDto;
import com.rak.userservice.dtos.SignupRequestDto;
import com.rak.userservice.dtos.UserResponseDto;
import com.rak.userservice.models.Token;
import com.rak.userservice.models.User;
import com.rak.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public UserResponseDto signup(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.signup(signupRequestDto);
    }

    @PostMapping("/login")
    public Token Login(@RequestBody LoginRequestDto loginRequestDto) {
        return  userService.login(loginRequestDto);
    }

    @GetMapping("/validate/{token}")
    public UserResponseDto validateToken(@PathVariable String token) {
        return userService.validateToken(token);
    }

}
