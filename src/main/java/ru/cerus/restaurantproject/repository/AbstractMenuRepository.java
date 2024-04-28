package ru.cerus.restaurantproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cerus.restaurantproject.domain.menu.AbstractMenu;

import java.util.List;

@Repository
public interface AbstractMenuRepository extends JpaRepository<AbstractMenu, Long> {
}
