package com.example.demoapi.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationUserDto {

    private String username;
    private String password;
}