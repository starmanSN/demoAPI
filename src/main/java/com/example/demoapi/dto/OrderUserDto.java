package com.example.demoapi.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderUserDto {

    private String username;

    private String firstname;

    private String lastname;

    private String phone;

    private String email;
}
