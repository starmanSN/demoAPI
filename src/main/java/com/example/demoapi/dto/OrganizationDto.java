package com.example.demoapi.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationDto {

    private Long id;

    private String name;

}