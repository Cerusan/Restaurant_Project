package ru.cerus.restaurantproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.cerus.restaurantproject.domain.menu.AbstractMenu;
import ru.cerus.restaurantproject.domain.menu.Drink;

import java.util.List;

@Repository
public interface AbstractMenuRepository<T extends AbstractMenu> extends JpaRepository<T, Long> {
    @Query("from Drink")
    List<Drink> findAllDrink();
}
