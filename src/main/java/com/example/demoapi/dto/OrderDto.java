package com.example.demoapi.dto;

import com.example.demoapi.entity.enums.OrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private String recipientName;

    private String recipientMail;

    private OrderStatus status;

    private OrderUserDto accountUser;

    private List<OrderItemDto> orderItems;
}