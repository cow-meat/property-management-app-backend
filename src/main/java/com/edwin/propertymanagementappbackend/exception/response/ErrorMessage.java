package com.edwin.propertymanagementappbackend.exception.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorMessage {

    private final String message;
    private final LocalDateTime dateTime;
}
