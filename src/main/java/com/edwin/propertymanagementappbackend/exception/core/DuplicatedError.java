package com.edwin.propertymanagementappbackend.exception.core;

public enum DuplicatedError {
    USER_EXISTED("User existed");

    private final String message;

    DuplicatedError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
