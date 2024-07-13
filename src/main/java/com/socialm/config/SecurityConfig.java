package com.socialm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disables CSRF protection
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/api/users/register", "/api/users/login").permitAll() // Allows unauthenticated access to registration and login endpoints
                .anyRequest().authenticated() // Requires authentication for all other requests
            )
            .formLogin(formLogin -> formLogin
                .loginPage("/login") // Specifies the login page URL
                .defaultSuccessUrl("/home", true) // Redirects to /home on successful login
                .permitAll() // Allows access to the login page for everyone
            )
            .logout(logout -> logout
                .permitAll() // Allows access to logout for everyone
            );

        return http.build();
    }
}
