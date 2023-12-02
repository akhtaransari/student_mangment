package com.bpktechnologies.exceptions;

/**
 * Custom exception class for handling student-related exceptions.
 * Extends RuntimeException for unchecked exception handling.
 */
public class StudentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor to set the exception message.
     *
     * @param message The detail message for this exception.
     */
    public StudentException(String message) {
        super(message);
    }
}
