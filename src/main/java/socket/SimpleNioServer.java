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
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @auther caiwei
 * @date 2020-04-29
 */
@Slf4j
public class SimpleNioServer {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        try {
            Selector serverSelector = Selector.open();
            //对应io编程中的服务端启动
            ServerSocketChannel listenerChannel = ServerSocketChannel.open();
            listenerChannel.bind(new InetSocketAddress(8002));
            listenerChannel.configureBlocking(false);
            listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT+SelectionKey.OP_READ);
            for (; ; ) {
                //select无参数表示会阻塞在这，如果有参数，那么会阻塞等待多久，之后继续执行
                if (serverSelector.select() > 0) {
                    Set<SelectionKey> set = serverSelector.selectedKeys();
                    Iterator<SelectionKey> keyIterator = set.iterator();
                    while (keyIterator.hasNext()) {
                        SelectionKey key = keyIterator.next();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(40);
                        if (key.isAcceptable()) {

                        }
                        if (key.isReadable()) {
                            try {
                                SocketChannel clientChannel = (SocketChannel) key.channel();
                                //将socket中数据读取到byteBuffer中。
                                clientChannel.read(byteBuffer);
                                //翻转缓存区
                                byteBuffer.flip();
                                System.out.println(new String(byteBuffer.array()));
                                byteBuffer.clear();
                                String msg = "月上柳梢头，人约黄昏后";
                                byteBuffer.put(msg.getBytes(StandardCharsets.UTF_8));
                                //翻转缓存区
                                byteBuffer.flip();
                                clientChannel.write(byteBuffer);
                                byteBuffer.clear();
                                clientChannel.close();

                            } finally {
                                keyIterator.remove();
                            }
                        }

                    }


                }
            }

        } catch (IOException e) {
            log.error("select open error", e);
        }

    }
}
