package concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @Name: ParkTest
 * @Description: 自己做一个锁，不做啦；知道LockSupport.pack()和LockSupport.unpack()
 * @auther: caiwei
 * @date: 2019/12/12 15:17
 */
public class ParkTest {

    private static ExecutorService threadPool = Executors.newCachedThreadPool();

    private static BlockingQueue<Thread> threadQueue = new LinkedBlockingQueue<>();

    private static volatile AtomicInteger flag = new AtomicInteger(0);

    public static void main(String[] args) {

        threadPool.submit(()->{
            if (flag.get() == 0) {
                System.out.println("thread:" + Thread.currentThread().getName() + "阻塞了，然后放到阻塞队列");
                flag.incrementAndGet();
                try {
                    threadQueue.put(Thread.currentThread());
                    LockSupport.park();
                    System.out.println("thread:" + Thread.currentThread().getName() + "又开始执行啦");
                } catch (InterruptedException e) {
                    System.out.println("中断异常");
                }
            }
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("母猪的产后护理");
        }
        threadPool.submit(()->{
            if (flag.get() == 1) {
                try {
                    System.out.println("thread:" + Thread.currentThread().getName() + "执行，唤醒另一个线程");
                    flag.incrementAndGet();
                    LockSupport.unpark(threadQueue.take());
                    System.out.println("thread:" + Thread.currentThread().getName() + "我完事了");
                } catch (InterruptedException e) {
                    System.out.println("中断异常");
                }
            }
        });
        threadPool.shutdown();
        System.out.println("thread:" + Thread.currentThread().getName() + "结束了");

    }

}
