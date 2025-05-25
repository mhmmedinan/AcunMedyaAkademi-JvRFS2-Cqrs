package com.rentacarcqrs.application.services.brands;

import com.rentacarcqrs.domain.entities.User;
import com.rentacarcqrs.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userRepository.findByEmail(username).orElseThrow(()->new AccessDeniedException("Access Denied"));
    }
}
