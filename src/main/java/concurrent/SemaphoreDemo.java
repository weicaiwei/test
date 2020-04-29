package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName: Semaphore
 * @Description: Semaphore可以控同时访问的线程个数，
 * 通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。
 * tryAcquire() 尝试获取一个许可，若获取成功，则立即返回true，若获取失败，则立即返回false
 * @auther: caiwei
 * @date: 2019/4/15 17:43
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(5);
        ExecutorService pool = Executors.newCachedThreadPool();
        for(int i = 0; i < 9; i++){
            pool.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.println("工人"+Thread.currentThread().getName()+"占用一个机器在生产...");
                    Thread.sleep(20000);
                    System.out.println("工人"+Thread.currentThread().getName()+"释放出机器");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }


    }
}
