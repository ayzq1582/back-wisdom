package com.zhy.wisdom.demo.map;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;

public class Structure {

    @Test
    public void  test01(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "我是谁");
        System.out.println(map.get("name"));
    }
}
