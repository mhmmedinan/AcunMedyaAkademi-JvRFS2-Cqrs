package com.rentacarcqrs.application.features.auth.commands.register;

import an.awesome.pipelinr.Command;
import com.rentacarcqrs.application.services.brands.UserService;
import com.rentacarcqrs.common.jwt.JwtService;
import com.rentacarcqrs.domain.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterCommandHandler implements Command.Handler<RegisterCommand,String>{

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public String handle(RegisterCommand command) {
        User user = new User();
        user.setFirstName(command.getFirstName());
        user.setLastName(command.getLastName());
        user.setEmail(command.getEmail());
        user.setPassword(passwordEncoder.encode(command.getPassword()));

        User createdUser = userService.add(user);
        return jwtService.generateToken(createdUser.getUsername(),
                createdUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());
    }
}
