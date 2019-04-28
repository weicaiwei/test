package concurrent;

import lombok.extern.java.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: CountDownLatchDemo
 * @Description: 实现类似计数器的功能。比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
 * @auther: caiwei
 * @date: 2019/4/15 17:38
 */
@Log
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        awaitCountZero();
        awaitTimeout();
    }

    //等待所有的子线程执行完毕，count变成0，latch.await()线程继续执行
    private static void awaitCountZero() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(4);
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < latch.getCount()-1; i++){
            pool.execute(() -> {
                log.info("我是线程：" + Thread.currentThread().getName());
                latch.countDown();
            });
        }
        pool.execute(()->{
            log.info("我是线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.execute(()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("其他线程执行完毕，线程："+Thread.currentThread().getName()+" 继续执行");
        });

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);
        log.info("主线程执行完毕");


    }
    //等待所有的子线程一定的时间，如果到了时间，即使count还未变成0，那么也不等待了，latch.await()继续执行
    private static void awaitTimeout() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(3);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 2; i++){
            pool.execute(() -> {
                log.info("我是线程：" + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        latch.await(10, TimeUnit.SECONDS);
        log.info("主线程:"+Thread.currentThread().getName()+" 等待够了，count数现在是："+latch.getCount()+"，但是timeout了，主程序继续执行");
    }
}

