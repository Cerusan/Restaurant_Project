package ru.cerus.restaurantproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.cerus.restaurantproject.domain.exception.ResourceNotFoundException;
import ru.cerus.restaurantproject.domain.user.Role;
import ru.cerus.restaurantproject.domain.user.User;
import ru.cerus.restaurantproject.repository.User.UserRepository;
import ru.cerus.restaurantproject.service.UserService;
import ru.cerus.restaurantproject.service.security.UserDetailsServiceImpl;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public void register(User user) {
        User userReg = new User(user.getName(), user.getSurname(), user.getLogin(),
                passwordEncoder.encode(user.getPassword()), Role.ROLE_USER);

        userRepository.save(userReg);
    }

    @Override
    public User getAuthUser() {
        return userDetailsService.getAuthUser();
    }

    @Override
    public void updateUser(User oldUser, User newUser) {

        oldUser.setName(newUser.getName());
        oldUser.setSurname(newUser.getSurname());

        userRepository.save(oldUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
