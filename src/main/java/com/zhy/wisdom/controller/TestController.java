package com.zhy.wisdom.controller;

import com.zhy.wisdom.service.TransactionalService;
import com.zhy.wisdom.domin.response.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController{

    @Resource
    private TransactionalService transactionalService;

    /**
     * 测试spring事务
     * @return
     */
    @GetMapping("/transactionalTest01")
    private BaseResponse transactionalTest01(){
        transactionalService.testTransactional();
        return buildResponse(1);
    }

    public static void main(String[] args) {
        System.out.println("哈哈哈，这周很成功啊！");
    }
}
