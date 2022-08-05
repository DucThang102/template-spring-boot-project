package com.example.openapispringboot.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(){
        super(StatusCode.NOT_FOUND.message);
    }
}
