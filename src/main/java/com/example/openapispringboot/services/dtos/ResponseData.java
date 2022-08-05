package com.example.openapispringboot.services.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData<T> extends BaseResponse {
    private T data;

    public ResponseData() {
        super();
    }


    public ResponseData(T data) {
        this.data = data;
    }

    public ResponseData(int statusCode, String message, T data) {
        super(statusCode, message);
        this.data = data;
    }

    @Schema(hidden = true)
    public void setSuccess(T data) {
        super.setSuccess();
        this.data = data;
    }

}
