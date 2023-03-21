package com.example.demoapi.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDto {

    private Integer quantity;

    private BigDecimal itemPrice;

    private BigDecimal totalPrice;

    private ProductDto product;
}
