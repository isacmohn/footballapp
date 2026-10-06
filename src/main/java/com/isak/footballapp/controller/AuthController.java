package com.isak.footballapp.controller;
import com.isak.footballapp.dto.RegisterRequest;
import com.isak.footballapp.entity.User;
import com.isak.footballapp.service.AuthService;
import org.springframework.web.bind.annotation.*;
import com.isak.footballapp.dto.LoginRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        return authService.login(request);
        }
    
}