package ru.cerus.restaurantproject.service;

import ru.cerus.restaurantproject.domain.user.User;

import java.util.List;

public interface UserService {

    void register(User user);

    User getAuthUser();

    void updateUser(Long id, User newUser);

    List<User> getAllUsers();

    User getUserById(long id);
}
