package com.example.demo.controller;

import com.example.demo.model.User; // Ensure this import is correct
import com.example.demo.repository.UserRepository; // Update this import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // Return the registration form view
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user); // Save the user to the database

        model.addAttribute("username", username);
        return "success"; // Return the success view
    }
}
