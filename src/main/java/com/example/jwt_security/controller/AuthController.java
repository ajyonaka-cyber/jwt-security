package com.example.jwt_security.controller;

import com.example.jwt_security.dto.LoginRequest;
import com.example.jwt_security.dto.LoginResponse;
import com.example.jwt_security.dto.RegisterResponse;


import com.example.jwt_security.dto.RegisterRequest;
import com.example.jwt_security.entity.User;
import com.example.jwt_security.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        User user = authService.register(request);

        RegisterResponse response = new RegisterResponse(
                user.getId(),
                user.getUsername(),
                user.getRole()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request) {

        String token = authService.login(request);

        return ResponseEntity.ok(new LoginResponse(token));
    }
}