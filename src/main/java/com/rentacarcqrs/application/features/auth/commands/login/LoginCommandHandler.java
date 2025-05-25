package com.rentacarcqrs.application.features.auth.commands.login;

import an.awesome.pipelinr.Command;
import com.rentacarcqrs.application.services.brands.UserService;
import com.rentacarcqrs.common.jwt.JwtService;
import io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.types.AuthorizationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginCommandHandler implements Command.Handler<LoginCommand,String> {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;

    @Override
    public String handle(LoginCommand command) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(command.getEmail(),command.getPassword()));
        if(!authentication.isAuthenticated())
            throw  new AuthorizationException("Login Failed");

        UserDetails user = userService.loadUserByUsername(command.getEmail());
        return jwtService.generateToken(command.getEmail(),
                user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());
    }
}
