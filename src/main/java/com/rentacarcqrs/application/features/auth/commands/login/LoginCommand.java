package com.rentacarcqrs.application.features.auth.commands.login;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginCommand implements Command<String> {

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
}
