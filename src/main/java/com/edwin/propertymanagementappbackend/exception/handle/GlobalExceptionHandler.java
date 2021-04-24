package com.edwin.propertymanagementappbackend.exception.handle;


import com.edwin.propertymanagementappbackend.exception.core.DuplicatedException;
import com.edwin.propertymanagementappbackend.exception.core.NotFoundException;
import com.edwin.propertymanagementappbackend.exception.response.ErrorMessage;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public ErrorMessage handle(NotFoundException exception) {
        return buildError(exception.getMessage());
    }

    @ExceptionHandler(DuplicatedException.class)
    @ResponseStatus(CONFLICT)
    @ResponseBody
    public ErrorMessage handle(DuplicatedException exception) {
        return buildError(exception.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    public ErrorMessage handle(MethodArgumentNotValidException exception) {
        String message = Objects.requireNonNull(exception.getBindingResult().getFieldError())
                .getDefaultMessage();

        return buildError(message);
    }

    private ErrorMessage buildError(String message) {
        return ErrorMessage.builder()
                .message(message)
                .dateTime(LocalDateTime.now())
                .build();
    }
}
