package com.zhy.wisdom.domin.response;

import lombok.Data;

@Data
public class BaseResponse {

    private Integer code = 200;
    private String message = "The call is successful!";
    private Object data;

    public BaseResponse(Object data) {
        this.data = data;
    }

    public BaseResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
