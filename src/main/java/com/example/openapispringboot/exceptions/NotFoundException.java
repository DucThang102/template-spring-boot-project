package com.example.openapispringboot.exceptions;

import com.example.openapispringboot.enumable.StatusCode;

public class NotFoundException extends RuntimeException {
    public NotFoundException(){
        super(StatusCode.NOT_FOUND.message);
    }
}
