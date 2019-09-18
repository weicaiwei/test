package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: SimpleBlockingQueue
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/9/18 16:39
 */
public class SimpleBlockingQueue<T> {

    private Object[] queue;

    private int count;

    private Lock lock;

    private Condition notEmpty;
    private Condition notFull;


    private int takeIndex;

    private int putIndex;

    public SimpleBlockingQueue(int capacity) {
        queue = new Object[capacity];
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull =  lock.newCondition();
    }


    public void put(T t) throws InterruptedException {
        final Lock lock = this.lock;
        lock.lock();
        try {
            while (count == queue.length) {
                notFull.await();
            }
            final Object[] queue = this.queue;
            queue[putIndex] = t;
            if( ++putIndex == queue.length){
                putIndex = 0;
            }
            count++;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    @SuppressWarnings("unchecked")
    public T take() throws InterruptedException {
        final Lock lock = this.lock;
        T o;
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            final Object[] queue = this.queue;

            o = (T) queue[takeIndex];
            queue[takeIndex] = null;
            if(++takeIndex == queue.length){
                takeIndex = 0;
            }
            count--;
            notFull.signal();
            return o;
        }finally {
            lock.unlock();
        }
    }

    public int size() {
        final Lock lock = this.lock;
        lock.lock();
        try {
            return count;
        }finally {
            lock.unlock();
        }

    }

}
