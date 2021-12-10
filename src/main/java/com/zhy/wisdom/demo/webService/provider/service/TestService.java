package com.zhy.wisdom.demo.webService.provider.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.WebServiceProvider;

/**
 * @author zhy
 * @version 1.0
 * @date 2021/10/18
 */
@WebService(name = "TestService", // 暴露服务名称
        targetNamespace = "http://service.provider.webService.demo.wisdom.zhy.com"// 命名空间,一般是接口的包名倒序
)
public interface TestService {
    @WebMethod
    public String sendMessage(@WebParam(name = "username") String username);

    @WebMethod
    public boolean getFlag(@WebParam(name = "username") String username);
}
