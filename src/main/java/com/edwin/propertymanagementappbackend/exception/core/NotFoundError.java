package com.edwin.propertymanagementappbackend.exception.core;

public enum NotFoundError {

    NOT_FOUND_SERVICE_TYPE("service type not found"),
    NOT_FOUND_ANNOUNCEMENT("Announcement not found"),
    NOT_FOUND_OWNER("owner not found"),
    USERNAME_OR_PASSWORD_ERROR("username or password error"),

    ;

    private final String message;

    NotFoundError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
