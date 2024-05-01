package ru.cerus.restaurantproject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cerus.restaurantproject.domain.user.User;
import ru.cerus.restaurantproject.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {
    private final UserServiceImpl userService;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute("userReg") User user) {
        return "auth/register";
    }

    @PostMapping("/process_register")
    public String registerProcess(@ModelAttribute("userReg") User user) {
        userService.register(user);
        return "redirect:/auth/login";
    }
}
