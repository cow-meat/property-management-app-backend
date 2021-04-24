package com.edwin.propertymanagementappbackend.exception.core;

public enum NotFoundError {

    NOT_FOUND_USER("User not found");

    private final String message;

    NotFoundError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
