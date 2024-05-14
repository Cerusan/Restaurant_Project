package ru.cerus.restaurantproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cerus.restaurantproject.domain.exception.ResourceNotFoundException;
import ru.cerus.restaurantproject.domain.menu.AbstractMenu;
import ru.cerus.restaurantproject.domain.menu.Category;
import ru.cerus.restaurantproject.domain.menu.Drink;
import ru.cerus.restaurantproject.domain.menu.Food;
import ru.cerus.restaurantproject.repository.AbstractMenuRepository;
import ru.cerus.restaurantproject.service.AbstractMenuService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AbstractMenuServiceImpl implements AbstractMenuService {

    private final AbstractMenuRepository abstractMenuRepository;
    private final CategoryServiceImpl categoryService;

    @Override
    @Transactional
    public void createAbstractMenu(Long id, AbstractMenu abstractMenu) {
        Category category = categoryService.getCategoryById(id);

        AbstractMenu abstractMenuNew = new Food();
        abstractMenuRepository.save(abstractMenu);
    }

    @Override
    @Transactional
    public void deleteAbstractMenu(Long id) {
        abstractMenuRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateAbstractMenu(Long id, AbstractMenu newAbstractMenu) {
        newAbstractMenu.setId(id);
        abstractMenuRepository.save(newAbstractMenu);
    }

    @Override
    @Transactional(readOnly = true)
    public AbstractMenu getAbstractMenuById(Long id) throws Throwable {
        return (AbstractMenu) abstractMenuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dish not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AbstractMenu> getAllAbstractMenu() {
        return abstractMenuRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Drink> getAllDrink() {
        return abstractMenuRepository.findAllDrink();
    }

    @Transactional(readOnly = true)
    public List<Food> getAllFood() {
        return abstractMenuRepository.findAllFood();
    }

}
