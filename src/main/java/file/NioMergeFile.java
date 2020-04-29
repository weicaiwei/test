package file;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Objects;

/**
 * TODO
 *
 * @auther caiwei
 * @date 2019-12-23
 */
@Slf4j
public class NioMergeFile {

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            String folderParentPath = "D:\\temp\\video\\";
            String folderSonPath = "D:\\temp\\video\\son\\";
            for (int i = 0; i < 10; i++) {
                File file = new File(folderParentPath+"video_"+i+".mp4");
                File folder = new File(folderSonPath);
                String[] fileList = folder.list();
                if (!file.exists()) {
                    if (!file.createNewFile()) {
                        log.error("文件创建失败");
                    }
                }
               /* RandomAccessFile fileRandomAccess = new RandomAccessFile(file, "rw");
                FileChannel fileChannel = fileRandomAccess.getChannel();
                if (Objects.nonNull(fileList)) {
                    for (String fileName : fileList) {
                        log.info("fileName:" + fileName);
                        FileChannel tempFileChannel = new RandomAccessFile(folderSonPath+fileName, "r").getChannel();
                        fileChannel.transferFrom(tempFileChannel, fileChannel.size(), tempFileChannel.size());
                    }
                }*/
                FileChannel fileChannel = new FileOutputStream(file).getChannel();
                if (Objects.nonNull(fileList)) {
                    for (String fileName : fileList) {
                        log.info("fileName:" + fileName);
                        FileChannel tempFileChannel = new FileInputStream(new File(folderSonPath+fileName)).getChannel();
                        fileChannel.transferFrom(tempFileChannel, fileChannel.size(), tempFileChannel.size());
                    }
                }

            }
            long stopTime = System.currentTimeMillis();
            log.info("文件合并完成，总耗时：" + (stopTime - startTime)+";平均耗时:"+(stopTime - startTime)/10);
        } catch (FileNotFoundException e) {
            log.error("文件创建异常：" + e);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
