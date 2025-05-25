package com.rentacarcqrs;

import com.rentacarcqrs.common.annotations.EnableSecurity;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Key;

@SpringBootApplication(scanBasePackages = {"com.rentacarcqrs",
"io.github.mhmmedinan.core_localization","io.github.mhmmedinan.core_persistence","io.github.mhmmedinan.core_crosscuttingconcerns"})
@EnableSecurity
public class RentACarCqrsApplication {

public static void main(String[] args) {

    SpringApplication.run(RentACarCqrsApplication.class, args);
  /*  Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    String base64 = Encoders.BASE64.encode(key.getEncoded());
    System.out.println(base64);*/
   }
}
