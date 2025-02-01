package com.example.loginauthapi.controllers;

import com.example.loginauthapi.domain.user.User;
import com.example.loginauthapi.dto.RegisterRequestDTO;
import com.example.loginauthapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("sucesso!");
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequestDTO request) {
        User savedUser = userService.registerUser(request);
        return ResponseEntity.ok(savedUser);
    }


}
