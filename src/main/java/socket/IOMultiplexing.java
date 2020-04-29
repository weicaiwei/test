package socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 仿照netty类型的多路复用服务器demo,这样似乎太复杂了，没必要监听OP_ACCEPT事件，直接接听OP_READ事件
 *
 * @auther caiwei
 * @date 2019-12-22
 */
@Slf4j
public class IOMultiplexing {
    public static void main(String[] args) {

        try {
            Selector serverSelector = Selector.open();
            Selector clientSelector = Selector.open();

            //线程池，包括serverSelector线程，clientSelector线程，和具体业务线程
            ExecutorService threadPool = new ThreadPoolExecutor(
                    11,
                    11,
                    0L,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(100));

            threadPool.execute(()->{
                try {
                    //对应io编程中的服务端启动
                    ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                    listenerChannel.bind(new InetSocketAddress(8001));
                    listenerChannel.configureBlocking(false);
                    listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
                    for (; ; ) {
                        try {
                            //监测是否有新的连接，此处的1指的是1毫秒
                            if (serverSelector.select(1) > 0) {
                                Set<SelectionKey> set = serverSelector.selectedKeys();
                                Iterator<SelectionKey> keyIterator = set.iterator();
                                while (keyIterator.hasNext()) {
                                    SelectionKey key = keyIterator.next();
                                    if (key.isAcceptable()) {
                                        try {
                                            //每来一个连接不是新建一个线程，而是直接注册到clientSelector中
                                            SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                                            clientChannel.configureBlocking(false);
                                            clientChannel.register(clientSelector, SelectionKey.OP_READ);
                                        } finally {
                                            keyIterator.remove();
                                        }
                                    }
                                }
                            }
                        } catch (IOException e) {
                            log.error("serverSelector循环异常",e);
                        }
                    }
                } catch (Exception e) {
                    log.error("serverSelector启动异常",e);
                }

            });


            threadPool.execute(() -> {
                for (; ; ) {
                    //(2)批量轮询是否有哪些连接有数据可读，此处的1指的是阻塞的时间是1ms
                    try {
                        if (clientSelector.select(1) > 0) {
                            Set<SelectionKey> set = clientSelector.selectedKeys();
                            Iterator<SelectionKey> keyIterator = set.iterator();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(40);
                            while (keyIterator.hasNext()) {
                                SelectionKey key = keyIterator.next();
                                if (key.isReadable()) {
                                    long timestamp = System.currentTimeMillis();
                                    threadPool.execute(()->{
                                        try {
                                            SocketChannel clientChannel = (SocketChannel) key.channel();
                                            //将socket中数据读取到byteBuffer中。
                                            clientChannel.read(byteBuffer);
                                            //翻转缓存区
                                            byteBuffer.flip();
                                            log.info(new String(byteBuffer.array()));
                                            byteBuffer.clear();
                                            String msg = "月上柳梢头，人约黄昏后";
                                            byteBuffer.put(msg.getBytes(StandardCharsets.UTF_8));
                                            //翻转缓存区
                                            byteBuffer.flip();
                                            clientChannel.write(byteBuffer);
                                            byteBuffer.clear();
                                            clientChannel.close();
                                        } catch (IOException e) {
                                            log.error("数据读取异常", e);
                                        } finally {
                                            keyIterator.remove();
                                        }
                                    });
                                    log.info("time need:" + (System.currentTimeMillis() - timestamp));


                                }
                            }
                        }
                    } catch (Exception e) {
                        log.error("clientSelector取出通道异常", e);
                    }
                }
            });

            log.info("多路复用器开启完毕，let's go");
        } catch (Exception e) {
            log.error("多路复用器开启失败",e);
        }

    }
}
