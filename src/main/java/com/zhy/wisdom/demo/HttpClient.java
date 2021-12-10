package com.zhy.wisdom.demo;

import com.zhy.wisdom.utils.HttpUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClient {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * MybatisController
     */
    @Test
    public void demo01(){
        String result = HttpUtil.doGet("http://localhost:8088//mybatis/getUserInfo");
        logger.info(result);
    }

    /**
     * 调用TestController
     */
    @Test
    public void demo02(){
        String result = HttpUtil.doGet("http://localhost:8088//test/transactionalTest01");
        logger.info(result);
    }

    /**
     * webService
     */
    @Test
    public void demo03(){
        String result = HttpUtil.doGet("http://localhost:8088//testWebService/getMessage");
        logger.info(result);
    }
}
