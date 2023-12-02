package com.bpktechnologies.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import lombok.extern.slf4j.Slf4j;

/**
 * GlobalExceptionHandler to handle exceptions globally.
 * Handles specific exceptions and provides appropriate responses with error details.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    	
	/**
	 * Handles NoResourceFoundException and returns a ResponseEntity with error details.
	 */
	@ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorDetail> noHandler(NoResourceFoundException ex, WebRequest wr) {
        log.warn("NoResourceFoundException: " + ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorDetail(ex.getMessage(), wr.getDescription(false), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }
	/**
     * Handles NoHandlerFoundException and returns a ResponseEntity with error details.
     */
	
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetail> noHandler(NoHandlerFoundException ex, WebRequest wr) {
        log.warn("NoHandlerFoundException: " + ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorDetail(ex.getMessage(), wr.getDescription(false), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles generic Exception and returns a ResponseEntity with error details.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> parentException(Exception ex, WebRequest wr) {
        log.warn("Exception: " + ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorDetail(ex.getMessage(), wr.getDescription(false), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles MethodArgumentNotValidException and returns a ResponseEntity with error details.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetail> methodArgValidException(MethodArgumentNotValidException ex, WebRequest wr) {
        log.warn("MethodArgumentNotValidException: " + ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorDetail(ex.getMessage(), wr.getDescription(false), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles StudentException and returns a ResponseEntity with error details.
     */
    @ExceptionHandler(StudentException.class)
    public ResponseEntity<ErrorDetail> gymException(StudentException ex, WebRequest wr) {
        log.warn("StudentException: " + ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorDetail(ex.getMessage(), wr.getDescription(false), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }
}
