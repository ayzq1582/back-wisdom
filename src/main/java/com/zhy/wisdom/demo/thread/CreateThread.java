package com.zhy.wisdom.demo.thread;


import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 多线程构造方法（4种）
 * 1.继承Thread类，重写run方法
 * 2.实现Runnable接口，重写run方法，实现Runnable接口的实现类的实例对象作为Thread构造函数的target
 * 3.通过Callable和FutureTask创建线程
 * 4.通过线程池创建线程
 */
public class CreateThread {

    private List<String> strArr = Arrays.asList("111", "222", "333", "444", "555", "666", "777");

    private Integer count = 0;

    /**
     * 继承Thread
     */
    class FunOne extends Thread{
        @Override
        public void run() {
            System.out.println(strArr.get(count));
            count += count;
        }
    }

    /**
     * 实现Runnable
     */
    class FunTwo implements Runnable{
        @Override
        public void run() {
            System.out.println(strArr.get(count));
            count += count;
        }
    }

    /**
     * 通过Callable和FutureTask创建线程
     */
    public void FunThree(){

    }

    @Test
    public void test(){
        FunOne funOne01 = new FunOne();
        funOne01.setName("线程funOne01");
        funOne01.start();
        System.out.println(Thread.currentThread().getName());

        FunOne funOne02 = new FunOne();
        funOne02.start();

        FunTwo funTwo = new FunTwo();
        funTwo.run();
    }
}
