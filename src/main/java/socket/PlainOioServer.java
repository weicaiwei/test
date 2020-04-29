package socket;

import lombok.extern.java.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName: PlainOioServer
 * @Description: 阻塞I/O服务端
 * @auther: caiwei
 * @date: 2019/4/16 23:51
 */
@Log
public class PlainOioServer {

    public static void main(String[] args) throws IOException {

        final ServerSocket socket = new ServerSocket(8080);
        try {
            for (; ; ) {
                final Socket clientSocket = socket.accept();
                if (null != clientSocket) {//这一步是多余的，因为socket.accept是阻塞的，如果没有连接过来，那么socket.accept会一直阻塞着，代码压根就不会向下运行
                    log.info("服务端收到一个连接请求");
                    new Thread(() -> {
                        try {
                            InputStream input = clientSocket.getInputStream();
                            byte[] bytes = new byte[1024];
                            input.read(bytes);
                            clientSocket.shutdownInput();
                            log.info("线程名字："+Thread.currentThread().getName());
                            log.info(new String(bytes, StandardCharsets.UTF_8));
                            OutputStream output = clientSocket.getOutputStream();
                            String statement = "雁行风过水，花落月临枝";
                            output.write(statement.getBytes(StandardCharsets.UTF_8));
                            clientSocket.shutdownOutput();
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
