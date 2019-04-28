package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName: NettyServer
 * @Description: netty 服务端
 * @auther: caiwei
 * @date: 2019/4/17 17:03
 */
public class NettyServer {

    public void start() {

        //创建两个EventLoop的组，EventLoop 这个相当于一个处理线程，是Netty接收请求和处理IO请求的线程
        //boss:接受传入的连接
        EventLoopGroup acceptor = new NioEventLoopGroup();
        //worker:当boss接受连接并注册被接受的连接到worker时，处理被接受连接的流量
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            //netty启动类
            ServerBootstrap bootstrap = new ServerBootstrap();
            //配置启动参数
            bootstrap.group(acceptor, worker);
            //设置选项
            bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
            //用于构造socketChannel工厂
            bootstrap.channel(NioServerSocketChannel.class);
            //传入自定义处理器客户端handler(具体处理数据场所)
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new ServerHandler());
                }
            });
            // 绑定端口，开始接收进来的连接
            int port = 8001;
            ChannelFuture future = bootstrap.bind(port).sync();
            // 等待服务器 socket 关闭
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            acceptor.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }
}
