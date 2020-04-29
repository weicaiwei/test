package smscat;

import org.smslib.Message;
import org.smslib.OutboundMessage;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;

import java.io.IOException;

/**
 * @ClassName: Test
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/9/22 23:21
 */
public class Test {

    public static void main(String[] args) {

        // ---------------创建串口设备，如果有多个，就创建多个--------------
        // 1、连接的网关ID（即短信猫端口编号）
        // 2、com口名称，如COM1或/dev/ttyS1（根据实际情况修改）
        // 3、串口波特率，如9600（根据实际情况修改）
        // 4、开发商，如Apple
        // 5、型号，如iphone4s
        SerialModemGateway gateway = new SerialModemGateway(
                "*" ,
                "COM4",
                9600,
                "",
                "");
        // 设置true，表示该网关可以接收短信
        gateway.setInbound( true);
        // 设置true，表示该网关可以发送短信
        gateway.setOutbound( true);

        //短信服务中心号码,设置这个，无论号码对错，都无法正确发送短信
        //gateway.setSmscNumber("17060326911");

        // -----------------创建发送短信的服务（它是单例的）----------------
        Service service = Service. getInstance();

        // ---------------------- 将设备加到服务中----------------------
        try {
            service.addGateway(gateway);
            // ------------------------- 启动服务 -------------------------
            service.startService();
            System.out.println("本机号吗是："+gateway.getSmscNumber());

            // ------------------------- 发送短信 -------------------------
            OutboundMessage msg = new OutboundMessage("17600602868" , "Hello World");
            msg.setEncoding(Message.MessageEncodings. ENCUCS2);

            service.queueMessage(msg);

            System.out.println("本机号吗是："+gateway.getSmscNumber());
            // ------------------------- 关闭服务 -------------------------
           // service.stopService();
            System.out.println("本机号吗是："+gateway.getSmscNumber());

        } catch (IOException | InterruptedException | SMSLibException e) {
            e.printStackTrace();
        }


    }
}
