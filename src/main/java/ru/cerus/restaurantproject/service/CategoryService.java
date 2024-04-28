package ru.cerus.restaurantproject.service;

import ru.cerus.restaurantproject.domain.menu.Category;

import java.util.List;

public interface CategoryService {
    /**
     * Метод создания нового объекта класса Category
     * @param category
     */
    void createCategory(Category category);

    /**
     * Метод удаления объекта класса Category
     * @param id
     */
    void deleteCategory(Long id);

    /**
     * Метод обновления существующего объекта класса Category
     * @param id
     * @param categoryUpdate
     */
    void updateCategory(Long id, Category categoryUpdate);

    /**
     * Метод получения существующего объекта класса Category по полю id
     * @param id
     * @return
     */
    Category getCategoryById(Long id);

    /**
     * Метод получения существующего объекта класса Category по полю name
     * @param name
     * @return
     */
    Category getCategoryByName(String name);

    /**
     * Метод получения всех существующих объектов класса Category
     * @return
     */
    List<Category> getAllCategory();
}
