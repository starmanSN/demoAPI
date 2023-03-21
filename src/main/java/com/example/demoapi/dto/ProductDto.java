package com.example.demoapi.dto;

import com.example.demoapi.entity.enums.Status;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    @NotBlank

    private String title;
    @NotNull
    @DecimalMin(
            value = "0.0",
            inclusive = false
    )
    @Digits(
            integer = 6,
            fraction = 2
    )
    private BigDecimal cost;

    @PastOrPresent
    @DateTimeFormat(
            pattern = "dd-MM-yyyy"
    )
    private LocalDate manufactureDate;

    @NotNull
    private Status status;

    private String organization;

}