package com.bpktechnologies.exceptions;

import java.time.LocalDateTime;

/**
 * Represents details of an error or exception.
 * Utilized to encapsulate error-related information.
 */
public record ErrorDetail(String message, String description, LocalDateTime timeStamp) {
    // This record class stores error-related information like message, description, and times-tamp.
}
