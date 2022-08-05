package com.example.openapispringboot.exceptions;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIncludeProperties({"statusCode", "message"})
public class ApplicationException extends RuntimeException {

    private int statusCode;
    private String message;

    public ApplicationException(StatusCode statusCode, String message) {
        this.statusCode = statusCode.code;
        this.message = message;
    }

}
