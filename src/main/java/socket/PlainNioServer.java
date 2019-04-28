package socket;

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

/**
 * @ClassName: PlainNioServer
 * @Description: 非阻塞式nio socket 服务端
 * @auther: caiwei
 * @date: 2019/4/17 11:31
 */
public class PlainNioServer {

    public static void main(String[] args) throws IOException {
        Selector serverSelector = Selector.open();
        Selector clientSelector = Selector.open();
        new Thread(() -> {
            try {
                //对应io编程中的服务端启动
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.bind(new InetSocketAddress(8001));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
                for (; ; ) {
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
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (; ; ) {
                    //(2)批量轮询是否有哪些连接有数据可读，此处的1指的是阻塞的时间是1ms
                    if (clientSelector.select(1) > 0) {
                        Set<SelectionKey> set = clientSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(40);
                        while (keyIterator.hasNext()) {
                            SelectionKey key = keyIterator.next();
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
                e.printStackTrace();
            }

        }).start();
        System.out.println("let's go");
    }
}
