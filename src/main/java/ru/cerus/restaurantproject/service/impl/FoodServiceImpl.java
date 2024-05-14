package ru.cerus.restaurantproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cerus.restaurantproject.domain.menu.AbstractMenu;
import ru.cerus.restaurantproject.domain.menu.Category;
import ru.cerus.restaurantproject.domain.menu.Drink;
import ru.cerus.restaurantproject.domain.menu.Food;
import ru.cerus.restaurantproject.repository.AbstractMenuRepository;
import ru.cerus.restaurantproject.service.AbstractMenuService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements AbstractMenuService {
    private final AbstractMenuRepository abstractMenuRepository;
    private final CategoryServiceImpl categoryService;

    @Override
    public void createAbstractMenu(Long categoryId, AbstractMenu abstractMenu) {
        Category category = categoryService.getCategoryById(categoryId);

        AbstractMenu abstractMenuNew = new Food();

        abstractMenuNew.setName(abstractMenu.getName());
        abstractMenuNew.setCalories(abstractMenu.getCalories());
        abstractMenuNew.setPrice(abstractMenu.getPrice());
        abstractMenuNew.setStructure(abstractMenu.getStructure());
        abstractMenuNew.setCarbohydrates(abstractMenu.getCarbohydrates());
        abstractMenuNew.setCategoryList(new ArrayList<>(Collections.singletonList(category)));

        abstractMenuRepository.save(abstractMenuNew);
    }

    @Override
    public void deleteAbstractMenu(Long id) {

    }

    @Override
    public void updateAbstractMenu(Long id, AbstractMenu newAbstractMenu) {

    }

    @Override
    public AbstractMenu getAbstractMenuById(Long id) throws Throwable {
        return null;
    }

    @Override
    public List<AbstractMenu> getAllAbstractMenu() {
        return abstractMenuRepository.findAll();
    }

    @Override
    public List<Drink> getAllDrink() {
        return null;
    }

    @Override
    public List<Food> getAllFood() {
        return null;
    }
}
