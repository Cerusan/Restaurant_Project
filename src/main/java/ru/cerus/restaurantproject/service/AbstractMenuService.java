package ru.cerus.restaurantproject.service;

import ru.cerus.restaurantproject.domain.menu.AbstractMenu;

import java.util.List;

public interface AbstractMenuService {
    void createAbstractMenu(AbstractMenu abstractMenu);

    void deleteAbstractMenu(Long id);

    void updateAbstractMenu(Long id, AbstractMenu newAbstractMenu);

    AbstractMenu getAbstractMenuById(Long id);

    List<AbstractMenu> getAllAbstractMenu();
}
