package socket;

/**
 * @ClassName: Client
 * @Description: 阻塞I/O客户端
 * @auther: caiwei
 * @date: 2019/4/17 00:10
 */
import lombok.extern.java.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@Log
public class Client {

    public static void main(String[] args) {
        while (true) {
            try {
                Thread.sleep(5000);
                Socket socket=new Socket("127.0.0.1",8001);
                OutputStream outputStream=socket.getOutputStream();
                String statement = "无生尽日欢，何来生死疑";
                outputStream.write(statement.getBytes(StandardCharsets.UTF_8));
                socket.shutdownOutput();
                InputStream input = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int i = input.read(bytes);
                log.info(String.valueOf(i));
                log.info(new String(bytes, StandardCharsets.UTF_8));
                socket.shutdownInput();
                socket.close();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }

        }
    }

}
