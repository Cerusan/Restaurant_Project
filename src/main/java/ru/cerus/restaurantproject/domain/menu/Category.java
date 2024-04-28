package ru.cerus.restaurantproject.domain.menu;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @ManyToMany
    @JoinTable(name = "tb_cathegory_menu",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id"))
    private List<AbstractMenu> abstractMenuList;

    public void addItemMenuToCategory(AbstractMenu abstractMenu) {
        abstractMenuList.add(abstractMenu);
    }

    @Override
    public String toString() {
        return name;
    }
}
