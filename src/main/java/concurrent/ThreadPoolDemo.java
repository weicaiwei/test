package concurrent;

import others.Print;
import lombok.extern.java.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ExecutorServiceDemo
 * @Description: 常用的3个线程池测试
 * @auther: caiwei
 * @date: 2019/4/16 10:51
 */
@Log
public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {

        executeThreadPool(ThreadPoolType.SINGLE);
        executeThreadPool(ThreadPoolType.CACHED);
        executeThreadPool(ThreadPoolType.FIXED);


    }
    static void executeThreadPool(ThreadPoolType type) throws InterruptedException {

        ExecutorService pool = null;
        switch (type) {
            case CACHED:
                //缓存线程池（缓存的是线程，可以设置线程存活时间）
                pool = Executors.newCachedThreadPool();
                break;
            case FIXED:
                //固定大小线程池
                pool = Executors.newFixedThreadPool(4);
                break;
            case SINGLE:
                //容量为1的线程池
                pool = Executors.newSingleThreadExecutor();
                break;
            default:
                Print.println("传入的线程池类型有问题");
                break;
        }
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 3000; i++){
            pool.execute(()->{
                try {
                    Print.print("线程："+Thread.currentThread().getName()+"执行中");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);
        Print.println();
        Print.println("线程池"+type+"消耗的时间是"+ (System.currentTimeMillis() - startTime));
    }

    enum ThreadPoolType {
        FIXED,SINGLE,CACHED,
    }



}
