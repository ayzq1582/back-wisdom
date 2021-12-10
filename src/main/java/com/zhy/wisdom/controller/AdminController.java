package com.zhy.wisdom.controller;

import com.zhy.wisdom.dao.UserAllMapper;
import com.zhy.wisdom.domin.response.BaseResponse;
import com.zhy.wisdom.entity.UserAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController{

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserAllMapper userAllMapper;

    @GetMapping("/getUserInfo")
    private BaseResponse getUserInfo(){
        logger.info("日志开启");
        List<UserAll> all = userAllMapper.getAll();
        return buildResponse(all);
    }
}
