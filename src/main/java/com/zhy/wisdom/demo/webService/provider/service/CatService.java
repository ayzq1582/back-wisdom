package com.zhy.wisdom.demo.webService.provider.service;

import com.zhy.wisdom.demo.webService.provider.entity.Hero;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author zll
 * @version 1.0
 * @date 2020/6/10 17:02
 */
@WebService(name = "CatService", // 暴露服务名称
        targetNamespace = "http://service.provider.webService.demo.wisdom.zhy.com"// 命名空间,一般是接口的包名倒序
)
public interface CatService {
    @WebMethod
    public String message(@WebParam(name = "hero") String hero);
}
