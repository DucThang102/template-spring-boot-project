package com.example.openapispringboot.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNoSuchElementFoundException(NotFoundException itemNotFoundException) {
        log.error("Failed to find the requested element", itemNotFoundException);
        return ResponseEntity.status(HttpStatus.OK).body(new ApplicationException( StatusCode.NOT_FOUND, itemNotFoundException.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllUncaughtException(Exception exception) {
        log.error("Unknown error occurred", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApplicationException(StatusCode.INTERNAL_SERVER_ERROR, StatusCode.INTERNAL_SERVER_ERROR.message));
    }

}
