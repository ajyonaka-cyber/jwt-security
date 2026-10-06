package com.example.jwt_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public String test() {
        return "JWT authentication is working!";
    }

    @GetMapping("/api/user")
    public String user() {
        return "Welcome USER! You have access to this endpoint.";
    }
}