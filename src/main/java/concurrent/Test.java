package concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: TwoThreadPoolTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/12/6 17:56
 */
@Slf4j
public class Test {


    public static void main(String[] args) {


        int a, b, c;
        a = b = c = 0;

        Lock lock = new ReentrantLock();

        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        threadPool.submit(() -> {
            System.out.println("hello:" + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            System.out.println("我把线程的状态设置为中断啦");
            for (int i = 0; i < 2; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println("休息100毫秒成功啦");
                } catch (InterruptedException e) {
                    log.error("中断异常", e);
                }
            }


        });

    }
}
