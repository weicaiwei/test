package concurrent;

import lombok.extern.java.Log;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: CyclicBarrierDemo
 * @Description: 实现让一组线程等待至某个状态之后再全部同时执行。叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用
 * @auther: caiwei
 * @date: 2019/4/15 17:42
 */
@Log
public class CyclicBarrierDemo {

    public static void main(String[] args) throws InterruptedException {

        awaitNoOtherTask();
        /*awaitDoOtherTask();*/


    }
    /**
     * @Title: awaitNoOtherTask
     * @Description: TODO
     * @params: []
     * @return: void
     * @throws:
     * @author: caiwei
     * @date: 2019/12/5 20:04
     */
    static void awaitNoOtherTask() {

        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService pool = Executors.newFixedThreadPool(6);

        for (int i = 0; i < 6; i++) {

            pool.execute(() -> {
                try {
                    System.out.println("线程：" + Thread.currentThread().getName() + "正在写入数据");
                    Thread.sleep(new Random().nextInt(3) * 1000);
                    System.out.println("线程：" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入数据");
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("其他线程数据写入完毕，线程：" + Thread.currentThread().getName() + "继续执行任务");

            });
        }
/*        //syclicBarrier是可重用的
        for(int i = 0; i < barrier.getParties(); i++){
            pool.execute(()->{
                try {
                    System.out.println("线程："+Thread.currentThread().getName()+"正在写入数据");
                    Thread.sleep(new Random().nextInt(3)*1000);
                    System.out.println("线程："+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入数据");
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("其他线程数据写入完毕，线程："+Thread.currentThread().getName()+"继续执行任务");

            });

        }*/
    }

    static void awaitDoOtherTask() {

        //当四个线程都到达barrier状态后，会从四个线程中随机选择一个线程去执行Runnable。
        CyclicBarrier barrier = new CyclicBarrier(4,
                ()-> System.out.println("线程："+Thread.currentThread().getName()+"执行此额外任务"));
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < barrier.getParties(); i++) {
            pool.execute(()->{
                try {
                    System.out.println("线程："+Thread.currentThread().getName()+"正在写入数据");
                    Thread.sleep(new Random().nextInt(3)*1000);
                    System.out.println("线程："+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入数据");
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("其他线程数据写入完毕，线程："+Thread.currentThread().getName()+"继续执行任务");

            });

        }
    }
}

