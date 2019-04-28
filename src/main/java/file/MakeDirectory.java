package file;

import lombok.extern.java.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Log
public class MakeDirectory {

    public static void main(String[] args) throws IOException {

        displayFileList();
    }

    static void displayFileList() {
        String filePath = "D:\\temp\\";
        File file = new File(filePath);
        if (file.exists()) {
            String[] fileList = file.list();
            for (String fileName : fileList) {
                log.info("文件有：" + fileName);
            }
        } else {
           log.info("该文件夹不存在");
        }
    }

    static void makeDirectory() throws IOException {

        String filePath = "D:\\temp\\";
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        //在指定位置创建目录，只会创建最后一级目录，如果上级目录不存在，那么返回false
        boolean result1 = file.mkdir();
        //在指定位置创建目录，这会创建路径中所有不存在的目录
        boolean result2 = file.mkdirs();
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(parentFile.getName());
        FileOutputStream output = new FileOutputStream(file);
        String yuanxi = "众里寻他千百度，蓦然回首，那人却在，灯火阑珊处";
        output.write(yuanxi.getBytes("utf-8"));
        output.flush();
        System.out.println(file.getName());
    }
}
