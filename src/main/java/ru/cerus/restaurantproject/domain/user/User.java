package ru.cerus.restaurantproject.domain.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов")
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(min = 2, max = 100, message = "Фамилия должна быть от 2 до 100 символов")
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Size(min = 2, max = 100, message = "Логин должен быть от 2 до 100 символов")
    @Column(name = "login")
    private String login;

    @NotNull
    @Size(min = 8, message = "Пароль должен быть от 8 символов")
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String name, String surname, String login, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
