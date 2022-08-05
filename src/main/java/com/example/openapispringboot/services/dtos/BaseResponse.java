package com.example.openapispringboot.services.dtos;

import com.example.openapispringboot.enumable.StatusCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseResponse {
    
    private int statusCode;
    private String message;


    public BaseResponse() {
        statusCode = StatusCode.SUCCESSFUL.code;
        message = StatusCode.SUCCESSFUL.message;
    }

    public BaseResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    @Schema(hidden = true)
    public void setSuccess(String message){
        this.statusCode = StatusCode.SUCCESSFUL.code;
        this.message = message;
    }

    public void setSuccess(){
        this.statusCode = StatusCode.SUCCESSFUL.code;
        this.message = StatusCode.SUCCESSFUL.message;
    }

    public void setFail() {
        this.statusCode = StatusCode.FAILED.code;
        this.message = StatusCode.FAILED.message;
    }

    @Schema(hidden = true)
    public void setFail(String msg) {
        this.statusCode = StatusCode.FAILED.code;
        this.message = msg;
    }

    @Schema(hidden = true)
    public void setFail(int statusCode,String msg) {
        this.statusCode = statusCode;
        this.message = msg;
    }

}
