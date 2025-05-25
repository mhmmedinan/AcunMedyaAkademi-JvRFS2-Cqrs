package com.rentacarcqrs.application.services.brands;

import com.rentacarcqrs.domain.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User add(User user);
}
