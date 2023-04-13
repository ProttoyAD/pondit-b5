package com.pondit.model.enums;

public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }
}
