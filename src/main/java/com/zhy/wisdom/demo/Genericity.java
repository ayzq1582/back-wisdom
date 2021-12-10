package com.zhy.wisdom.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 */
public class Genericity {

    @Test
    public void test(){
        demo01<String> demo01 = new demo01<>("凤凰芝");
        System.out.println(demo01.getName());

        new ArrayList<>();
    }

    @Before
    public void before(){
        System.out.println("before function>>>");
    }

    @After
    public void after(){
        System.out.println("after function>>>");
    }

    class demo01<T>{
        private T name;

        public T getName() {
            return name;
        }

        public void setName(T name) {
            this.name = name;
        }

        public demo01(T name) {
            this.name = name;
        }

    }
    // 泛型方法，在返回类型前面使用泛型字母
    public static <T> void test1(T t){
        System.out.println(t);
    }

    // T 只能是list 或者list 的子类
    public static <T extends List> void test2(T t){
        t.add("aa");
    }

    // T... 可变参数   --->   T[]
    public static <T extends Closeable> void test3(T...a) {
        for (T temp : a) {
            try {
                if (null != temp) {
                    temp.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
