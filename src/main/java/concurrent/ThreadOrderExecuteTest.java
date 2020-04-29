package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @auther caiwei
 * @date 2020-04-05
 */
public class ThreadOrderExecuteTest {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition order0 = lock.newCondition();
        Condition order1 = lock.newCondition();
        Condition order2 = lock.newCondition();

        Thread thread0 = new Thread(new Task(lock, order0, order0,"0"));
        Thread thread1 = new Thread(new Task(lock, order0, order1,"1"));
        Thread thread2 = new Thread(new Task(lock, order1, order2,"2"));
        Thread thread3 = new Thread(new Task(lock, order2, order2,"3"));

        thread3.start();
        thread2.start();
        thread1.start();
        thread0.start();





/*        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        threadPool.execute(new Task(lock, order2, order2,"3"));
        threadPool.execute(new Task(lock, order1, order2,"2"));
        threadPool.execute(new Task(lock, order0, order1,"1"));
        threadPool.execute(new Task(lock, order0, order0,"0"));*/




    }
}

class Task implements Runnable {

    private Lock lock;

    private Condition conditionPre;

    private Condition conditionPost;

    private String code;

    Task(Lock lock, Condition conditionPre, Condition conditionPost, String code) {
        this.lock = lock;
        this.conditionPre = conditionPre;
        this.conditionPost = conditionPost;
        this.code = code;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            if(!code.equals("0")){
                conditionPre.await();
            }
            System.out.println("===="+code+"====thread name[" + Thread.currentThread().getName() + "]");
            if(!code.equals("3")){
                conditionPost.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}