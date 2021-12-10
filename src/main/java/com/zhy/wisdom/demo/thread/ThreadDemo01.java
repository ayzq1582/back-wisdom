package com.zhy.wisdom.demo.thread;

class ThreadDemo01 implements Runnable {
    /**
     * 使用静态成员变量作为100张票的保存变量，是一个共享资源。
     */
    private static int tickets = 100;

    @Override
    public void run() {
        // 完成售票过程
        while (true) {
            if (!funOne()) break;
        }
    }

    private boolean funOne(){
        // 字符串可以作为锁对象，因为双引号包含的字符串不管在代码中如何运行，有且只有一个
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "售出了" + tickets + "张票");
            tickets--;
        } else {
            System.out.println(Thread.currentThread().getName() + "售罄！！！");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadDemo01(),"售票人员1");
        Thread t2 = new Thread(new ThreadDemo01(),"售票人员2");
        Thread t3 = new Thread(new ThreadDemo01(),"售票人员3");
        t1.start();
        t2.start();
        t3.start();
    }
}
