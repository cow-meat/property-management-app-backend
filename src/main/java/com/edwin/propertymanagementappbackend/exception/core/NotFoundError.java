package com.edwin.propertymanagementappbackend.exception.core;

public enum NotFoundError {

    NOT_FOUND_SERVICE_TYPE("service type not found");

    private final String message;

    NotFoundError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
