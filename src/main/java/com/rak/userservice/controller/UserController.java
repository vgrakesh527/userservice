package com.rak.userservice.controller;

import com.rak.userservice.dtos.LoginRequestDto;
import com.rak.userservice.dtos.SignupRequestDto;
import com.rak.userservice.dtos.TokenResponseDto;
import com.rak.userservice.dtos.UserResponseDto;
import com.rak.userservice.exceptions.TokenNotFoundException;
import com.rak.userservice.exceptions.UserNotFoundException;
import com.rak.userservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto) {
        var response = userService.signup(signupRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> Login(@RequestBody LoginRequestDto loginRequestDto) throws UserNotFoundException {
        var response = userService.login(loginRequestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/validate/{token}")
    public ResponseEntity<UserResponseDto> validateToken(@PathVariable String token) throws TokenNotFoundException {
        var response =  userService.validateToken(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
