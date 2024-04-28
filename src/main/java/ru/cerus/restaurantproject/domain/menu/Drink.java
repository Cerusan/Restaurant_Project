package ru.cerus.restaurantproject.domain.menu;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_drinks")
public class Drink extends AbstractMenu{

    @Column(name = "strength")
    private int strength;

    @Column(name = "categories")
    @ManyToMany
    @JoinTable(name = "tb_cathegory_menu",
            joinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private List<Category> categoryList;
}
