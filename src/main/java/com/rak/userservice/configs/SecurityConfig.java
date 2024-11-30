package com.rak.userservice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll() // Allow all requests without authentication
                )
                .csrf(AbstractHttpConfigurer::disable) // Use this to explicitly disable CSRF in a non-deprecated way
                .formLogin(AbstractHttpConfigurer::disable) // Disable form-based login
                .httpBasic(AbstractHttpConfigurer::disable); // Disable basic authentication

        return http.build();
    }
}
