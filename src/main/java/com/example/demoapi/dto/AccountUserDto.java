package com.example.demoapi.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountUserDto {

    private Long id;

    private String username;

    private String password;

    private String matchingPassword;

    private String email;

}
