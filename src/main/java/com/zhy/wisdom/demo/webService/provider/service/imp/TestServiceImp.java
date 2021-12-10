package com.zhy.wisdom.demo.webService.provider.service.imp;

import com.zhy.wisdom.demo.webService.provider.service.TestService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @author zll
 * @version 1.0
 * @date 2020/6/10 15:31
 */
@WebService(serviceName = "TestService", // 与接口中指定的name一致
        targetNamespace = "http://service.provider.webService.demo.wisdom.zhy.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.zhy.wisdom.demo.webService.provider.service.TestService"// 接口地址
)
@Component
public class TestServiceImp implements TestService {

    @Override
    public String sendMessage(String username) {
        return "=====Hello! " + username + "=====";
    }

    @Override
    public boolean getFlag(String username) {
        //
        return true;
    }
}
