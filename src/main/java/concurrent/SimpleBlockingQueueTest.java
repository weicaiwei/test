package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: SimpleBlockingQueueTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/9/18 16:45
 */
public class SimpleBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        SimpleBlockingQueue<String> simpleBlockingQueue = new SimpleBlockingQueue<>(5);

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                    simpleBlockingQueue.put(String.valueOf(i));
                    System.out.println("放进去一个，里面有："+simpleBlockingQueue.size()+"个");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });
        Thread.sleep(20000);
        threadPool.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                    simpleBlockingQueue.take();
                    System.out.println("拿出来一个，还有："+simpleBlockingQueue.size()+"个");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });

    }
}
