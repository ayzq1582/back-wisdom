package com.zhy.wisdom.demo.webService.consumer;

import com.alibaba.fastjson.JSON;
import com.zhy.wisdom.demo.webService.provider.entity.Hero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/testWebService"))
public class RequestController {

    //在一个方法中连续调用多次WebService接口，每次调用前需要重置上下文。
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    @GetMapping("/getMessage")
    public String getMessage() {
        Thread.currentThread().setContextClassLoader(classLoader);//在获取连接之前 还原上下文
        System.out.println("======开始调用webservice接口=====");
        String url = "http://localhost:8088/webService/CatService?wsdl";
        String methodName = "message";
        System.out.println("Calling" + url);
        String result = "";
        try {
            result = clientUtil.callWebSV(url, methodName, "钢铁侠");
        } catch (Exception e) {
            System.err.println("接口调用失败！！！！");
            return "失败";
        }
        System.out.println("===Finished!===恭喜你啊！！！CatService接口调用成功！！！===获得的数据是：" + result);
        return "Finished!";
    }

    @GetMapping("/getMessage2")
    public String getMessage2() {
        Thread.currentThread().setContextClassLoader(classLoader);//在获取连接之前 还原上下文
        System.out.println("======开始调用webservice接口=====");
        String url = "http://localhost:8088/webService/TestService?wsdl";
        String methodName = "sendMessage";
        System.out.println("Calling" + url);
        String result = "";
        try {
            result = clientUtil.callWebSV(url, methodName, "username");
        } catch (Exception e) {
            System.err.println("接口调用失败！！！！");
            return "失败";
        }
        System.out.println("===Finished!===恭喜你啊！！！TestService接口调用成功！！！===获得的数据是：" + result);
        return "Finished!";
    }

    public static void main(String[] args) {
        String url = "http://localhost:8088/webService/CatService?wsdl";
        String methodName = "message";
        System.out.println("Calling" + url);
        String result = "";
        Hero hero = new Hero();
        hero.setName("贝吉塔");
        hero.setAge(14);
        try {
            result = clientUtil.callWebSV(url, methodName, JSON.toJSONString(hero));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}