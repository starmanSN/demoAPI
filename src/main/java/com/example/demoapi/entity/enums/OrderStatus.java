package com.example.demoapi.entity.enums;

public enum OrderStatus {
    CREATED("Создан"),
    DELIVERED("Доставлен"),
    RECEIVED("Получен"),
    CANCELED("Отменем"),
    PROCESSING("В обработке");

    private final String status;

    OrderStatus(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}