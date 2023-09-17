package com.inditex.sales.resource;

import java.time.LocalDateTime;

/**
 * Wrapper class for application errors
 *
 * @param timestamp the time of the event
 * @param status    the http status code
 * @param error     the http error
 * @param message   the error message
 */
public record ErrorResponse(
    LocalDateTime timestamp,
    int status,
    String error,
    String message) {
}
