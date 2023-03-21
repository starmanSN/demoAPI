package com.example.demoapi.config;

import com.example.demoapi.config.jwt.JwtConfigurer;
import com.example.demoapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class SecurityConfig {

    public static final String LOGIN_ENDPOINT = "/api/v1/auth/login";
    public static final String USER_ENDPOINT = "/api/v1/user";
    public static final String REGISTRATION_ENDPOINT = "/api/v1/auth/register";

    private final JwtConfigurer jwtConfigurer;

    public SecurityConfig(JwtConfigurer jwtConfigurer) {
        this.jwtConfigurer = jwtConfigurer;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (requests) -> {
                    requests.requestMatchers(LOGIN_ENDPOINT).permitAll();
                    requests.requestMatchers(REGISTRATION_ENDPOINT).permitAll();
                    requests.anyRequest().authenticated();
                }
        );

        http.apply(jwtConfigurer);
        http.httpBasic().disable();
        http.csrf().disable();

        return http.build();
    }
}
