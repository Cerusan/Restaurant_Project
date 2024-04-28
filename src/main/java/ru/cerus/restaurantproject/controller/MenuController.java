package ru.cerus.restaurantproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cerus.restaurantproject.domain.menu.AbstractMenu;
import ru.cerus.restaurantproject.domain.menu.Drink;
import ru.cerus.restaurantproject.service.AbstractMenuService;
import ru.cerus.restaurantproject.service.CategoryService;
import ru.cerus.restaurantproject.service.DrinkService;
import ru.cerus.restaurantproject.service.FoodService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/menu/")
public class MenuController {
    private final AbstractMenuService abstractMenuService;
    private final CategoryService categoryService;

    @GetMapping
    public String menuList (Model model){
        List<AbstractMenu> menuList = abstractMenuService.getAllAbstractMenu();
        model.addAttribute("menu", menuList);
        return "menu/menu";
    }

    @GetMapping("drinks")
    public String drinkList (Model model){
        List<Drink> drinkList = abstractMenuService.getAllDrink();
        model.addAttribute("menu", drinkList);
        return "menu/drinks";
    }
}
