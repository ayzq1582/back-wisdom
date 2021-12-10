package com.zhy.wisdom.demo.map;

import org.junit.Test;

public class BaseDemo {

    /**
     * hash值
     */
    @Test
    public void test01(){
        String str = "hash值测试";
        int i = str.hashCode();
        System.out.println(i);
    }
}
