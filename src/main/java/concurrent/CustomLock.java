package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: CustomLock
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/6/24 16:52
 */
public class CustomLock {

    public static void main(String[] args){

        Lock lock = new ReentrantLock();
        System.out.println(System.getProperty("java.vm.name"));
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++){
            threadPool.submit(()->{
                try {
                    lock.lock();
                    Thread.sleep(3000);
                    System.out.println("线程名字是：" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();

                }
            });
        }
        threadPool.shutdown();

    }
}
