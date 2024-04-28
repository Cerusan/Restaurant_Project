package ru.cerus.restaurantproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cerus.restaurantproject.domain.exception.ResourceNotFoundException;
import ru.cerus.restaurantproject.domain.menu.Food;
import ru.cerus.restaurantproject.repository.FoodRepository;
import ru.cerus.restaurantproject.service.FoodService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public void createFood(Food food) {
        foodRepository.save(food);
    }

    @Override
    @Transactional
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateFood(Long id, Food foodUpdate) {
        foodUpdate.setId(id);
        foodRepository.save(foodUpdate);
    }

    @Override
    @Transactional(readOnly = true)
    public Food getFoodById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Food getFoodByName(String name) {
        return foodRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }
}
