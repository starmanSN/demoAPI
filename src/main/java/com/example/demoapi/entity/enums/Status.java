package com.example.demoapi.entity.enums;

public enum Status {
    ACTIVE("Доступно"),
    DISABLED("Недоступно");

    private final String title;

    public String getTitle() {
        return this.title;
    }

    private Status(final String title) {
        this.title = title;
    }
}