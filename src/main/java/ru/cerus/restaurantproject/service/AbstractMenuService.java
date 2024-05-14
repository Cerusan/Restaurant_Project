package ru.cerus.restaurantproject.service;

import ru.cerus.restaurantproject.domain.menu.AbstractMenu;
import ru.cerus.restaurantproject.domain.menu.Drink;
import ru.cerus.restaurantproject.domain.menu.Food;

import java.util.List;

public interface AbstractMenuService {
    void createAbstractMenu(Long id, AbstractMenu abstractMenu);

    void deleteAbstractMenu(Long id);

    void updateAbstractMenu(Long id, AbstractMenu newAbstractMenu);

    AbstractMenu getAbstractMenuById(Long id) throws Throwable;

    List<AbstractMenu> getAllAbstractMenu();

    List<Drink> getAllDrink();

    List<Food> getAllFood();
}
