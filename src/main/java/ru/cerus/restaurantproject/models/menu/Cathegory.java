package ru.cerus.restaurantproject.models.menu;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_cathegory")
public class Cathegory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "menus")
    @ManyToMany
    @JoinTable(name = "tb_food_drinks",
            joinColumns = @JoinColumn(name = "cathegory_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "food_drinks_id", referencedColumnName = "id"))
    private Set<AbstractMenu> abstractMenuList;

    public void addItemMenuToCathegory(AbstractMenu abstractMenu) {
        abstractMenuList.add(abstractMenu);
    }

}
