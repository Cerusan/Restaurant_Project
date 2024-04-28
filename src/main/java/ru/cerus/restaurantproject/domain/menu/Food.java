package ru.cerus.restaurantproject.domain.menu;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_foods")
@DiscriminatorValue("Food")
public class Food extends AbstractMenu{

}
