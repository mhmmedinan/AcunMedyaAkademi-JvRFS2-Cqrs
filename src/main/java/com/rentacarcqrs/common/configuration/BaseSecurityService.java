package com.rentacarcqrs.common.configuration;

import com.rentacarcqrs.common.filters.JwtAuthFilter;
import com.rentacarcqrs.domain.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BaseSecurityService {

    private final JwtAuthFilter jwtAuthFilter;

    private static final String[] WHITE_LIST_URLS= {
            "/swagger-ui/**",
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/api/auth/**"
    };

    public HttpSecurity configureCoreSecurity(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req->req.requestMatchers(WHITE_LIST_URLS).permitAll())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity;
    }


}
