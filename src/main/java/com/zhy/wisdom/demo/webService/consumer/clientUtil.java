package com.zhy.wisdom.demo.webService.consumer;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.lang.reflect.Method;

/**
 * @author zhy
 * @version 1.0
 * @date 2021/10/18
 */
public class clientUtil {

    public static String callWebSV(String wsdUrl, String operationName, String... params) throws Exception {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(wsdUrl);
        //client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects;
        // invoke("方法名",参数1,参数2,参数3....);
        objects = client.invoke(operationName, params);
        return objects[0].toString();
    }
}

