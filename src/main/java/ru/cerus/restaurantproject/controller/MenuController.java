package ru.cerus.restaurantproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.cerus.restaurantproject.domain.menu.AbstractMenu;
import ru.cerus.restaurantproject.domain.menu.Category;
import ru.cerus.restaurantproject.domain.menu.Drink;
import ru.cerus.restaurantproject.domain.menu.Food;
import ru.cerus.restaurantproject.service.CategoryService;
import ru.cerus.restaurantproject.service.impl.FoodServiceImpl;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final FoodServiceImpl foodService;
    private final CategoryService categoryService;

    @GetMapping
    public String menuList (Model model){
        List<AbstractMenu> menuList = foodService.getAllAbstractMenu();
        model.addAttribute("menu", menuList);
        return "menu/menu";
    }

    @GetMapping("/drinks")
    public String drinkList (Model model){
        List<Drink> drinkList = foodService.getAllDrink();
        model.addAttribute("drinks", drinkList);
        return "menu/drinks";
    }

    @GetMapping("/foods")
    public String foodList (Model model){
        List<Food> foodList = foodService.getAllFood();
        model.addAttribute("foods", foodList);
        return "menu/food";
    }

    @GetMapping("/create")
    public String createMenu() {
        return "menu/addMenuPage";
    }

    @GetMapping("/create/{category_id}/addFood")
    public String createFood(@PathVariable("category_id") Long id,
                             @ModelAttribute("newDish") Food food,
                             Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "menu/addFood";
    }

    @PostMapping("/create/{category_id}/addFood/process_addFood")
    public String createFoodProcess(@PathVariable("category_id") Long categoryId,
                                    @ModelAttribute("newDish") Food food,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "menu/addFood";

        Category category = categoryService.getCategoryById(categoryId);

        foodService.createAbstractMenu(category.getId(), food);
        return "redirect:/menu/foods";
    }

}
