package ru.cerus.restaurantproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cerus.restaurantproject.domain.exception.ResourceNotFoundException;
import ru.cerus.restaurantproject.domain.menu.AbstractMenu;
import ru.cerus.restaurantproject.domain.menu.Category;
import ru.cerus.restaurantproject.repository.CategoryRepository;
import ru.cerus.restaurantproject.service.CategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateCategory(Long id, Category categoryUpdate) {
        categoryUpdate.setId(id);
        categoryRepository.save(categoryUpdate);
    }

    @Override
    @Transactional(readOnly = true)
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Drink not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Drink not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

}
