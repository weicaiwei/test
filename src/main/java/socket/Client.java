package socket;

/**
 * @ClassName: Client
 * @Description: 阻塞I/O客户端
 * @auther: caiwei
 * @date: 2019/4/17 00:10
 */

import lombok.extern.java.Log;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Log
public class Client {

    public static void main(String[] args) {
        try {

            Socket socket=new Socket("localhost",8001);
            OutputStream outputStream=socket.getOutputStream();
            String statement = "床前明月光，玻璃好上霜";
            outputStream.write(statement.getBytes(StandardCharsets.UTF_8));
            socket.shutdownOutput();
            InputStream input = socket.getInputStream();
            int time = input.read();
            long currentTimeMillis = (time - 2208988800L) * 1000L;
            System.out.println((new Date(currentTimeMillis)));
            socket.shutdownInput();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
