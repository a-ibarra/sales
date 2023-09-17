package com.inditex.sales.error;

/**
 * Marker exception for all the application
 */
public class SalesException extends RuntimeException {

    public SalesException(final String message) {
        super(message);
    }
}
