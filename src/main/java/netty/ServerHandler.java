package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import others.Print;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName: ServerHandler
 * @Description: 服务端处理类
 * @auther: caiwei
 * @date: 2019/4/17 17:54
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {


    /**
     * 读取客户端发送的信息,向客户端发送消息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        Print.println("进入ServerHandler处理器");

        //处理客户端发送的消息
        ByteBuf buf = (ByteBuf) msg;
        byte[] result = new byte[buf.readableBytes()];
        buf.readBytes(result);
        String receiveMessage = new String(result, StandardCharsets.UTF_8);
        Print.println(receiveMessage);
        //释放资源
        buf.release();
        //向客户端发送消息
        String response = "生死凭一笑，净污两由之";
        ByteBuf encode = ctx.alloc().buffer(4 * response.length());
        encode.writeBytes(response.getBytes(StandardCharsets.UTF_8));
        ctx.write(encode);
        ctx.flush();
    }

    /**
     * 异常处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        //当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }

    //信息获取完毕后操作
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

}
