package com.example.loginauthapi.service;

import com.example.loginauthapi.domain.user.User;
import com.example.loginauthapi.dto.RegisterRequestDTO;
import com.example.loginauthapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(RegisterRequestDTO request) {
        Optional<User> existingUser = userRepository.findByEmail(request.email());
        if (existingUser.isPresent()) {
            throw new RuntimeException("E-mail já cadastrado!");
        }

        User user = new User(request.name(), request.email(), request.password());
        return userRepository.save(user);
    }
}