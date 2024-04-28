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
@DiscriminatorValue("Drink")
public class Drink extends AbstractMenu{

    @Column(name = "strength")
    private int strength;

}
