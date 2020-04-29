package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Name: ConditionTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/12/13 11:24
 */
public class ConditionTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition testCondition = lock.newCondition();

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.execute(()->{
            try {
                lock.lock();
                System.out.println("thread:" + Thread.currentThread().getName()+"开始等待");
                testCondition.await();
                System.out.println("thread:" + Thread.currentThread().getName()+"等待结束");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        });

        threadPool.execute(()->{
            lock.lock();
            System.out.println("thread:" + Thread.currentThread().getName()+"开始唤醒");
            testCondition.signal();
            System.out.println("thread:" + Thread.currentThread().getName()+"唤醒结束");
            lock.unlock();

        });
    }
}
