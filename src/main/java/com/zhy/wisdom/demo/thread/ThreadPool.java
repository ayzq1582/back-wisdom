package com.zhy.wisdom.demo.thread;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    // TODO 构造方法
    /**
     * 有四种构建方式
     * 前三种都是根据第四重来创建的
     */
        /*public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
                    BlockingQueue<Runnable> workQueue);
        public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
                    BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory);
        public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
                    BlockingQueue<Runnable> workQueue,RejectedExecutionHandler handler);
        public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
                    BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory,RejectedExecutionHandler handler);*/

    // ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 3, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(5));

    // TODO 创建线程池参数解释
    /**
     * corePoolSize：核心池的大小，这个参数跟后面讲述的线程池的实现原理有非常大的关系。在创建了线程池后，默认情况下，线程池中并没有任何线程，而是等待有任务到来才创建线程去执行任务，除非调用了prestartAllCoreThreads()或者prestartCoreThread()方法，从这2个方法的名字就可以看出，是预创建线程的意思，即在没有任务到来之前就创建corePoolSize个线程或者一个线程。默认情况下，在创建了线程池后，线程池中的线程数为0，当有任务来之后，就会创建一个线程去执行任务，当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中；
     * maximumPoolSize：线程池最大线程数，这个参数也是一个非常重要的参数，它表示在线程池中最多能创建多少个线程；
     * keepAliveTime：表示线程没有任务执行时最多保持多久时间会终止。默认情况下，只有当线程池中的线程数大于corePoolSize时，keepAliveTime才会起作用，直到线程池中的线程数不大于corePoolSize，即当线程池中的线程数大于corePoolSize时，如果一个线程空闲的时间达到keepAliveTime，则会终止，直到线程池中的线程数不超过corePoolSize。但是如果调用了allowCoreThreadTimeOut(boolean)方法，在线程池中的线程数不大于corePoolSize时，keepAliveTime参数也会起作用，直到线程池中的线程数为0；
     * unit：参数keepAliveTime的时间单位，有7种取值，在TimeUnit类中有7种静态属性：
     *       TimeUnit.DAYS;              //天
     *       TimeUnit.HOURS;             //小时
     *       TimeUnit.MINUTES;           //分钟
     *       TimeUnit.SECONDS;           //秒
     *       TimeUnit.MILLISECONDS;      //毫秒
     *       TimeUnit.MICROSECONDS;      //微妙
     *       TimeUnit.NANOSECONDS;       //纳秒
     * workQueue：一个阻塞队列，用来存储等待执行的任务，这个参数的选择也很重要，会对线程池的运行过程产生重大影响，一般来说，这里的阻塞队列有以下几种选择：ArrayBlockingQueue和PriorityBlockingQueue使用较少，一般使用LinkedBlockingQueue和Synchronous。线程池的排队策略与BlockingQueue有关
     *       ArrayBlockingQueue;
     *       LinkedBlockingQueue;
     *       SynchronousQueue;
     * threadFactory：线程工厂，主要用来创建线程；
     * handler：表示当拒绝处理任务时的策略，有以下四种取值：
     *       ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
     *       ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
     *       ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
     *       ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
     */
    // TODO 继承关系
    /**
     * ThreadPoolExecutor->AbstractExecutorService->ExecutorService->Executor
     *
     * Executor是一个顶层接口，在它里面只声明了一个方法execute(Runnable)，返回值为void，参数为Runnable类型，从字面意思可以理解，就是用来执行传进去的任务的；
     * 然后ExecutorService接口继承了Executor接口，并声明了一些方法：submit、invokeAll、invokeAny以及shutDown等；
     * 抽象类AbstractExecutorService实现了ExecutorService接口，基本实现了ExecutorService中声明的所有方法；
     * 然后ThreadPoolExecutor继承了类AbstractExecutorService。
     * 在ThreadPoolExecutor类中有几个非常重要的方法：
     *      execute()：方法实际上是Executor中声明的方法，在ThreadPoolExecutor进行了具体的实现，这个方法是ThreadPoolExecutor的核心方法，通过这个方法可以向线程池提交一个任务，交由线程池去执行。
     *      submit()：方法是在ExecutorService中声明的方法，在AbstractExecutorService就已经有了具体的实现，在ThreadPoolExecutor中并没有对其进行重写，这个方法也是用来向线程池提交任务的，但是它和execute()方法不同，它能够返回任务执行的结果，去看submit()方法的实现，会发现它实际上还是调用的execute()方法，只不过它利用了Future来获取任务执行结果（Future相关内容将在下一篇讲述）。
     *      shutdown()：关闭线程池
     *      shutdownNow()：关闭线程池
     */
    // TODO 任务核心执行原理
    /**
     * 1）首先，要清楚corePoolSize和maximumPoolSize的含义；
     * 2）其次，要知道Worker是用来起到什么作用的；
     * 3）要知道任务提交给线程池之后的处理策略，这里总结一下主要有4点：
     *      如果当前线程池中的线程数目小于corePoolSize，则每来一个任务，就会创建一个线程去执行这个任务；
     *      如果当前线程池中的线程数目>=corePoolSize，则每来一个任务，会尝试将其添加到任务缓存队列当中，若添加成功，则该任务会等待空闲线程将其取出去执行；若添加失败（一般来说是任务缓存队列已满），则会尝试创建新的线程去执行这个任务；
     *      如果当前线程池中的线程数目达到maximumPoolSize，则会采取任务拒绝策略进行处理；
     *      如果线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止，直至线程池中的线程数目不大于corePoolSize；如果允许为核心池中的线程设置存活时间，那么核心池中的线程空闲时间超过keepAliveTime，线程也会被终止。
     */
    // TODO 任务缓存队列及排队策略
    /**
     * workQueue的类型为BlockingQueue<Runnable>，通常可以取下面三种类型：
     *      1）ArrayBlockingQueue：基于数组的先进先出队列，此队列创建时必须指定大小；
     *      2）LinkedBlockingQueue：基于链表的先进先出队列，如果创建时没有指定此队列大小，则默认为Integer.MAX_VALUE；
     *      3）synchronousQueue：这个队列比较特殊，它不会保存提交的任务，而是将直接新建一个线程来执行新来的任务。
     */
    // TODO 线程池的关闭
    /**
     * ThreadPoolExecutor提供了两个方法，用于线程池的关闭，分别是shutdown()和shutdownNow()，其中：
     *      shutdown()：不会立即终止线程池，而是要等所有任务缓存队列中的任务都执行完后才终止，但再也不会接受新的任务
     *      shutdownNow()：立即终止线程池，并尝试打断正在执行的任务，并且清空任务缓存队列，返回尚未执行的任务
     */

    // TODO 线程池容量的动态调整
    /**
     * ThreadPoolExecutor提供了动态调整线程池容量大小的方法：setCorePoolSize()和setMaximumPoolSize()，
     *      setCorePoolSize：设置核心池大小
     *      setMaximumPoolSize：设置线程池最大能创建的线程数目大小
     * 当上述参数从小变大时，ThreadPoolExecutor进行线程赋值，还可能立即创建新的线程来执行任务
     */

    /**
     * 创建线程池 ThreadPoolExecutor
     */

    @Test
    public void demo01(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+
                    "，队列中等待执行的任务数目："+executor.getQueue().size()+
                    "，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    class MyTask implements Runnable{
        private Integer taskNum;

        public Integer getTaskNum() {
            return taskNum;
        }
        public void setTaskNum(Integer taskNum) {
            this.taskNum = taskNum;
        }

        public MyTask(Integer taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public void run() {
            System.out.println("编号："+this.taskNum+", 正在执行任务！");
            try {
                Thread.currentThread().sleep(4000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("编号："+this.taskNum+", 正在执行结束！");
        }
    }

    // TODO 不过在java doc中，并不提倡我们直接使用ThreadPoolExecutor，而是使用Executors类中提供的几个静态方法来创建线程池：
    /**
     * Executors.newCachedThreadPool();        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
     * Executors.newSingleThreadExecutor();   //创建容量为1的缓冲池
     * Executors.newFixedThreadPool(int);    //创建固定容量大小的缓冲池
     */
    /*public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }
    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService
                (new ThreadPoolExecutor(1, 1,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>()));
    }
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
    }*/
    // TODO 线程池大小设定
    /**
     * 如果是CPU密集型任务，就需要尽量压榨CPU，参考值可以设为 NCPU+1
     * 如果是IO密集型任务，参考值可以设置为2*NCPU
     */
}
