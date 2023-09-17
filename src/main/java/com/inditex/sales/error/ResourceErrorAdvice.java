package com.inditex.sales.error;

import com.inditex.sales.resource.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

/**
 * Advice for Controller Failures
 */
@ControllerAdvice
public class ResourceErrorAdvice {

    /**
     * Transform binding validation errors to response
     *
     * @param ex the Validation exception
     * @return the ErrorResponse
     */
    @ResponseBody
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInternalServerError(final ValidationException ex) {
        return new ErrorResponse(LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            ex.getBindingErrors());
    }
}
