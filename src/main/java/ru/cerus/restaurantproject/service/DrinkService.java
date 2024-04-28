package ru.cerus.restaurantproject.service;

import ru.cerus.restaurantproject.domain.menu.Drink;

import java.util.List;
import java.util.Optional;

public interface DrinkService {
    /**
     * Метод создания нового объекта класса Drink
     * @param drink
     */
    void createDrink(Drink drink);

    /**
     * Метод удаления существующего объекта класса Drink
     * @param id
     */
    void deleteDrink(Long id);

    /**
     * Метод обновления существующего объекта класса Drink
     * @param id
     * @param drinkUpdate
     */
    void updateDrink(Long id, Drink drinkUpdate);

    /**
     * Метод получения существующего объекта класса Drink по id
     * @param id
     * @return
     */
    Drink getDrinkById(Long id);

    /**
     * Метод получения существующего объекта класса Drink по name
     * @param name
     * @return
     */
    Drink getDrinkByName(String name);

    /**
     * Метод получения всех существующих объектов класса Drink
     * @return
     */
    List<Drink> getAllDrink();
}
