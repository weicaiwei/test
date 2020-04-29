package file;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @ClassName: SegmentFile
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/10/24 09:36
 */
@Slf4j
public class SegmentFile {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\temp\\video\\movie.mp4");
        if (file.exists()) {
            //创建随机读取文件对象
            RandomAccessFile targetFile = new RandomAccessFile(file, "r");
            long fileLength = targetFile.length();
            log.info("fileLength=============" + fileLength);
 
            byte[] cache = new byte[20 * 1024 * 1024];

            int flag;
            int count = 0;
            while ((flag = targetFile.read(cache))!=-1){
                count++;
                System.out.println(Thread.currentThread().getName()+"循环"+count+"次数");
                File createdFile = new File("D:\\temp\\video\\movie_" + count + ".mp4");
                OutputStream outputStream = new FileOutputStream(createdFile);
                outputStream.write(cache, 0, flag);
            }
        } else {
            log.info("文件：D:\\temp\\video\\movie.mp4=========不存在");

        }
    }
}
