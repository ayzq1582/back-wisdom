package com.zhy.wisdom.demo.webService.provider.service.imp;

import com.alibaba.fastjson.JSON;
import com.zhy.wisdom.demo.webService.provider.entity.Hero;
import com.zhy.wisdom.demo.webService.provider.service.CatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @author zll
 * @version 1.0
 * @date 2020/6/10 17:05
 */
@WebService(serviceName = "CatService", // 与接口中指定的name一致
        targetNamespace = "http://service.provider.webService.demo.wisdom.zhy.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.zhy.wisdom.demo.webService.provider.service.CatService"// 接口地址
)
@Component
public class CatServiceImp implements CatService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String message(String hero) {
        logger.info("CatService message:{}", hero);
        return hero;
    }
}
