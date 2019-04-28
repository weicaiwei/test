package concurrent;

import others.Print;

import java.util.concurrent.*;

/**
 * @ClassName: FutureDemo
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/4/18 15:56
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        getByFutureTask();
        getByFuture();
    }

    //通过future与Callable获取异步任务执行结果
    static void getByFuture() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future future = pool.submit(()->{
            String message = null;
            /**
             * 此处的lambda表达式如果没有返回值，解析成Runnable对象
             * 如果有返回值，解析成Callable对象
             */
            try {
                Thread.sleep(5000);
                message="母猪的产后护理";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return message;

        });
        System.out.println("异步going");
        Print.println("得到异步结果："+ future.get());
    }

    //通过futureTask获取异步任务执行结果
    static void getByFutureTask() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        FutureTask<String> task = new FutureTask<>(() -> {
            Thread.sleep(5000);
            return "母猪的产后护理";
        });
        pool.submit(task);
        Print.println("异步任务已经提交");
        Print.println(task.get());
    }
}
