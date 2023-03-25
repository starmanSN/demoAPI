package com.example.demoapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public static final String LOGIN_URL = "/auth/login";
    public static final String LOGOUT_URL = "/logout";
    public static final String DEFAULT_SUCCESS_URL = "/product/all";
    public static final String REGISTRATION_ENDPOINT = "/auth/register";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage(LOGIN_URL)
                .loginProcessingUrl(REGISTRATION_ENDPOINT)
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher(LOGOUT_URL))
                .logoutSuccessUrl(DEFAULT_SUCCESS_URL).deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .csrf().disable();
        return http.build();
    }
}
