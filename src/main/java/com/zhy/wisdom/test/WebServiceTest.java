package com.zhy.wisdom.test;

import com.zhy.wisdom.utils.HttpUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void demo03(){
        String result = HttpUtil.doGet("http://localhost:8088//testWebService/getMessage");
        logger.info(result);
        System.out.println(result);
    }
}
