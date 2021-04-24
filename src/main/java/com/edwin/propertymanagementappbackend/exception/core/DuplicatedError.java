package com.edwin.propertymanagementappbackend.exception.core;

public enum DuplicatedError {
    SERVICE_TYPE_EXISTED("Service type existed"),
    OWNER_EXISTED("Owner existed"),

    ;

    private final String message;

    DuplicatedError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
