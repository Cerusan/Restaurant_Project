package ru.cerus.restaurantproject.models.menu;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@MappedSuperclass
@Entity
/*@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)*/
public abstract class AbstractMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "calories")
    private int calories;
    @Column(name = "cathegories")
    @ManyToMany
    @JoinTable(name = "tb_food_drinks",
            joinColumns = @JoinColumn(name = "food_drinks_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cathegory_id", referencedColumnName = "id"))
    private Set<Cathegory> cathegoryList;
    @Column(name = "price")
    private int price;
    @Column(name = "carbohydrates")
    private double carbohydrates;
    @Column(name = "structure")
    private String structure;

}
