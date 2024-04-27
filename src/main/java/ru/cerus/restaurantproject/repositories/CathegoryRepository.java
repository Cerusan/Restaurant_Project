package ru.cerus.restaurantproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cerus.restaurantproject.models.menu.Cathegory;

import java.util.List;

@Repository
public interface CathegoryRepository extends JpaRepository<Cathegory, Long> {
    List<Cathegory> findByName(String name);
}
