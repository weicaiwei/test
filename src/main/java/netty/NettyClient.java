package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName: NettyClient
 * @Description: netty 客户端
 * @auther: caiwei
 * @date: 2019/4/17 18:28
 */
public class NettyClient {

    public void connect(String host, int port) {

        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            //EventLoop的组
            bootstrap.group(worker);
            //用于构造socketChannel工厂
            bootstrap.channel(NioSocketChannel.class);
            //保持连接
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            //自定义客户端Handler
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ClientHandler());
                }
            });
            //开启客户端监听
            ChannelFuture future = bootstrap.connect(host,port).sync();
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            worker.shutdownGracefully();
        }
    }
}
