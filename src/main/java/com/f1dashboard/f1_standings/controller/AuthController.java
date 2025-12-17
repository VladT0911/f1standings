package com.f1dashboard.f1_standings.controller;

import com.f1dashboard.f1_standings.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        String error = userService.registerUser(username, password);
        if (error != null) {
            model.addAttribute("error", error);
            return "register";
        }
        model.addAttribute("success", "Registration successful! You can now login.");
        return "register";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
