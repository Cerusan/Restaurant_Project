package ru.cerus.restaurantproject.controller.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cerus.restaurantproject.domain.user.User;
import ru.cerus.restaurantproject.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping
    public String userInformation(Model model){
        User user = userService.getAuthUser();

        if (user != null) {
            model.addAttribute("user", user);
            return "user/userPage";
        } else
            return "auth/login";
    }

    @PostMapping("/edit-process")
    public String updateUser(@ModelAttribute("user") User userNew){
        User userOld = userService.getAuthUser();
        userService.updateUser(userOld, userNew);
        return "redirect:/user";
    }

}
