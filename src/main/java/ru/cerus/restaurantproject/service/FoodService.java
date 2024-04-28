package ru.cerus.restaurantproject.service;

import ru.cerus.restaurantproject.domain.menu.Food;

import java.util.List;

public interface FoodService {
    /**
     * Метод создания нового объекта класса Food
     * @param food
     */
    void createFood(Food food);

    /**
     * Метод удаления существующего объекта класса Food
     * @param id
     */
    void deleteFood(Long id);

    /**
     * Метод обновления существующего объекта класса Food
     * @param id
     * @param foodUpdate
     */
    void updateFood(Long id, Food foodUpdate);

    /**
     * Метод получения существующего объекта класса Food по id
     * @param id
     * @return
     */
    Food getFoodById(Long id);

    /**
     * Метод получения существующего объекта класса Food по name
     * @param name
     * @return
     */
    Food getFoodByName(String name);

    /**
     * Метод получения всех существующих объектов класса Food
     * @return
     */
    List<Food> getAllFood();
}
