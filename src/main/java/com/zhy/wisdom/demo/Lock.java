package com.zhy.wisdom.demo;

import org.junit.Test;

/**
 * java锁机制
 */
public class Lock {


    @Test
    public void test01(){
        //for (int i=1; i<=10; i++) {
        //    myThread myThread = new myThread(i);
        //    myThread.run();
        //}
        myThread01 myThread1 = new myThread01(1);
        myThread02 myThread2 = new myThread02(2);
        new Thread(myThread1).start();
        new Thread(myThread2).start();
    }

    class myThread01 implements Runnable{

        private Integer threadNum;

        public myThread01(Integer threadNum) {
            this.threadNum = threadNum;
        }

        @Override
        public void run() {
            // funOne("线程"+threadNum);
            funTwo();
        }
    }

    class myThread02 implements Runnable{

        private Integer threadNum;

        public myThread02(Integer threadNum) {
            this.threadNum = threadNum;
        }

        @Override
        public void run() {
            // funOne("线程"+threadNum);
            funThree();
        }
    }

    private void funOne(String threadName){
        System.out.println(threadName+"执行了funOne");
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(threadName+"执行funOne结束");
    }

    private void funTwo(){
        for (int i = 1;i<100;i++){
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("funTwo 执行了地"+i+"条");
        }
    }

    private void funThree(){
        for (int i = 1;i<100;i++){
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("funThree 执行了地"+i+"条");
        }
    }
}
