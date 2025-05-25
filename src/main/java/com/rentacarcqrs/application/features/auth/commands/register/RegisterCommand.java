package com.rentacarcqrs.application.features.auth.commands.register;

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
public class RegisterCommand implements Command<String> {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$",
            message = "Şifre en az 8 karakter olmalı, büyük harf, küçük harf, sayı ve özel karakter içermelidir")
    private String password;
}
