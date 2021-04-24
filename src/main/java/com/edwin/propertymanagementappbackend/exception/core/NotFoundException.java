package com.edwin.propertymanagementappbackend.exception.core;

import com.edwin.propertymanagementappbackend.exception.CommonException;

public class NotFoundException extends CommonException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(NotFoundError notFoundError) {
        super(notFoundError.getMessage());
    }
}
