package com.zhy.wisdom.controller;

import com.zhy.wisdom.domin.response.BaseResponse;

public class BaseController {

    BaseResponse buildResponse(Object data){
        return new BaseResponse(data);
    }

    BaseResponse buildResponse(Integer code, String msg){
        return new BaseResponse(code, msg, null);
    }
}
