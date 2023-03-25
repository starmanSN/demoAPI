package com.example.demoapi.controller;

import com.example.demoapi.dto.AccountUserDto;
import com.example.demoapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login-form";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        AccountUserDto accountUserDto = new AccountUserDto();
        model.addAttribute("AccountUserDto", accountUserDto);
        return "auth/registration-form";
    }

    @PostMapping("/register")
    public String handleRegistrationForm(@Valid AccountUserDto accountUserDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "auth/registration-form";
        }

        final String username = accountUserDto.getUsername();
        try {
            userService.findByUsername(username);
            model.addAttribute("AccountUserDto", accountUserDto);
            model.addAttribute("registrationError", "Username already exists");
            return "auth/registration-form";
        } catch (UsernameNotFoundException ignored) {
        }
        userService.register(accountUserDto);
        model.addAttribute("username", username);
        return "auth/registration-confirmation";
    }
}