package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import others.Print;

/**
 * @ClassName: ClientHandler
 * @Description: 客户端处理类
 * @auther: caiwei
 * @date: 2019/4/17 23:11
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 接收服务端发送过来的消息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Print.println("进入ClientHandler处理器");
        ByteBuf buf = (ByteBuf) msg;
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        Print.println(new String(bytes));
        buf.release();
        //自己加的（网上的demo少了这个close操作，导致closeFuture.sync被阻塞在await()中）
        ctx.close();
    }

    /**
     * 异常处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 向服务端发送信息
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String msg = "无生尽日欢，何来生死疑";
        ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());
        encoded.writeBytes(msg.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }

}
