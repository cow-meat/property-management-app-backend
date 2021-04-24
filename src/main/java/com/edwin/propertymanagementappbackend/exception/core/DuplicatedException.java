package com.edwin.propertymanagementappbackend.exception.core;

import com.edwin.propertymanagementappbackend.exception.CommonException;

public class DuplicatedException extends CommonException {

    public DuplicatedException(String message) {
        super(message);
    }

    public DuplicatedException(DuplicatedError duplicatedError) {
        super(duplicatedError.getMessage());
    }
}
