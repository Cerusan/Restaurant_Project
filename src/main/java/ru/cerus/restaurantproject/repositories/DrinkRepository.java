package ru.cerus.restaurantproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cerus.restaurantproject.models.menu.Drink;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
    List<Drink> findByName(String name);
}
