package com.inditex.sales.error;

import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Validation exception for resource components
 */
public class ValidationException extends SalesException {

    @Getter
    private final BindingResult bindingResult;

    public ValidationException(final String message, final BindingResult bindingResult) {
        super(message);
        this.bindingResult = bindingResult;
    }

    public String getBindingErrors() {
        final List<ObjectError> errors = bindingResult.getAllErrors();
        return errors.stream().map(error -> {
            if (error instanceof final FieldError fe) {
                return String.format("%s has invalid value, %s.", fe.getField(), fe.getDefaultMessage());
            } else {
                return error.toString();
            }
        }).collect(Collectors.joining(" | "));
    }
}
