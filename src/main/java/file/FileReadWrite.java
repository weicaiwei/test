package file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FileReadWrite {

    public static void main(String[] args) throws IOException, InterruptedException {

        RandomAccessFile file = new RandomAccessFile("D:\\temp\\caiwei.txt", "rw");


    }

    static void read() throws IOException {
        RandomAccessFile file = new RandomAccessFile("D:\\temp\\元夕.txt", "rw");
        System.out.println(file.length() );
        FileChannel fileChannel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1);
        byte[] bytes = new byte[1024];
        int i = 0;
        while (fileChannel.read(buffer) != -1) {
            buffer.flip();
            bytes[i] = buffer.get();
            buffer.clear();
            i++;
        }
        System.out.println("读取了："+i+"次");
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
        file.close();
    }

    static void write() throws IOException {
        RandomAccessFile file = new RandomAccessFile("D:\\temp\\元夕.txt", "rw");
        file.seek(file.length()/2);
        FileChannel fileChannel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer
                .append("去年元夜时，花市灯如昼。\r\n")
                .append("月上柳梢头，人约黄昏后。\r\n")
                .append("今年元夜时，月与灯依旧。\r\n")
                .append("不见去年人，泪湿春衫袖。\r\n");
        byte[] bytes = stringBuffer.toString().getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes.length);
        for (byte b : bytes) {
            buffer.put(b);
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }
        file.close();



    }
}
