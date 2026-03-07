package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.dto.UserResponseDTO;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Register user (No password returned)
    @PostMapping("/register")
    public UserResponseDTO registerUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }

    // Test endpoint
    @GetMapping("/test")
    public String test() {
        return "User Controller Working!";
    }

    // Get all users (No password returned)
    @GetMapping("/all")
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .toList();
    }

@PostMapping("/login")
public String loginUser(@RequestBody User user) {

    User existingUser = userRepository.findByEmail(user.getEmail());

    if (existingUser == null) {
        return "User not found!";
    }

    if (!existingUser.getPassword().equals(user.getPassword())) {
        return "Invalid password!";
    }

    return "Login successful!";
}
}