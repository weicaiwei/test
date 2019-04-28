package netty;

import others.Print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: Test
 * @Description: 运行入口
 * @auther: caiwei
 * @date: 2019/4/17 23:27
 */
public class Test {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(() -> {
            Print.println("服务器启动");
            new NettyServer().start();
        });
        pool.execute(()->{
            int i = 1;
            for (; ; ) {
                try {
                    Thread.sleep(10000);
                    Print.println("客户端发送第"+i+"次请求");
                    NettyClient client = new NettyClient();
                    client.connect("127.0.0.1", 8001);
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
