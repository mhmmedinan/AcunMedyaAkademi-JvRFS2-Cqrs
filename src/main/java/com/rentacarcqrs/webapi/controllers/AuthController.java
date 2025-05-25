package com.rentacarcqrs.webapi.controllers;

import an.awesome.pipelinr.Pipeline;
import com.rentacarcqrs.application.features.auth.commands.login.LoginCommand;
import com.rentacarcqrs.application.features.auth.commands.register.RegisterCommand;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final Pipeline pipeline;

    @PostMapping("register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterCommand command){
        return ResponseEntity.ok(command.execute(pipeline));
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginCommand command){
        return ResponseEntity.ok(command.execute(pipeline));
    }
}
