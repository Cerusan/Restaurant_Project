package ru.cerus.restaurantproject.controller.User;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cerus.restaurantproject.domain.user.User;
import ru.cerus.restaurantproject.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserServiceImpl userService;

    @GetMapping
    public String adminInformation(Model model){
        User admin = userService.getAuthUser();

        if (admin != null) {
            model.addAttribute("admin", admin);
            return "admin/adminPage";
        } else
            return "auth/login";
    }
}
