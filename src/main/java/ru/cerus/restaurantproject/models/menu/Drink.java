package ru.cerus.restaurantproject.models.menu;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_drinks")
public class Drink extends AbstractMenu{

    @Column(name = "strength")
    private int strength;
}
