package ru.cerus.restaurantproject.domain.menu;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@DiscriminatorValue("Food")
public class Food extends AbstractMenu{

}
