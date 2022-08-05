package com.example.openapispringboot.enumable;

public enum StatusCode {

    INTERNAL_SERVER_ERROR(500, "Internal server error!"),
    NOT_FOUND(404, "Not found !"),
    SUCCESSFUL(1, "SUCCESSFUL"),
    FAILED(0, "FAILED");

    public final int code;
    public final String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
