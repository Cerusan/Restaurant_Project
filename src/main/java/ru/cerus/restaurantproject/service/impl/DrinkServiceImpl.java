package ru.cerus.restaurantproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cerus.restaurantproject.domain.exception.ResourceNotFoundException;
import ru.cerus.restaurantproject.domain.menu.Drink;
import ru.cerus.restaurantproject.repository.DrinkRepository;
import ru.cerus.restaurantproject.service.DrinkService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;

    @Override
    @Transactional
    public void createDrink(Drink drink) {
        //Saved if idea of this method will not work
        /*Drink drinkNew = Drink.builder()
                .name(drink.getName())
                .calories(drink.getCalories())
                .categoryList(drink.getCategoryList())
                .price(drink.getPrice())
                .carbohydrates(drink.getCarbohydrates())
                .structure(drink.getStructure())
                .build();*/

        drinkRepository.save(drink);
    }

    @Override
    @Transactional
    public void deleteDrink(Long id) {
        drinkRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateDrink(Long id, Drink drinkUpdate) {
        //Saved if idea of this method will not work
        /*Drink drinkOld = drinkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Drink not found"));

        drinkOld.setName(drinkUpdate.getName());
        drinkOld.setCalories(drinkUpdate.getCalories());
        drinkOld.setCategoryList(drinkUpdate.getCategoryList());
        drinkOld.setPrice(drinkUpdate.getPrice());
        drinkOld.setCarbohydrates(drinkUpdate.getCarbohydrates());
        drinkOld.setStructure(drinkUpdate.getStructure());
        drinkOld.setStrength(drinkUpdate.getStrength());

        drinkRepository.save(drinkOld);*/

        drinkUpdate.setId(id);
        drinkRepository.save(drinkUpdate);
    }

    @Override
    @Transactional(readOnly = true)
    public Drink getDrinkById(Long id) {
        return drinkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Drink not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Drink getDrinkByName(String name) {
        return drinkRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Drink not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Drink> getAllDrink() {
        return drinkRepository.findAll();
    }
}
