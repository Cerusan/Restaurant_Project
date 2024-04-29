package ru.cerus.restaurantproject.service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.cerus.restaurantproject.domain.exception.ResourceNotFoundException;
import ru.cerus.restaurantproject.domain.user.User;
import ru.cerus.restaurantproject.repository.User.UserRepository;
import ru.cerus.restaurantproject.security.UserDetailsImpl;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return new UserDetailsImpl(user);
    }

    public User getAuthUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails;

        if (authentication instanceof AnonymousAuthenticationToken)
            return null;
        else
            userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userDetails.getUser();
    }
}
