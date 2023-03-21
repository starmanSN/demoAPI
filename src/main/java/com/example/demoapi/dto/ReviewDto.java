package com.example.demoapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    private ProductDto product;
    @NotBlank
    private String comment;
    @NotBlank
    private String captchaCode;

}