package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Name: ThreadPoolTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/12/12 23:07
 */
public class ThreadPoolTest {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
                threadPool.submit(()->{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前线程:" + Thread.currentThread().getName());
                });
        }
    }
}
