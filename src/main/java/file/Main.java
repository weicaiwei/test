package file;

import org.apache.commons.io.FilenameUtils;

import java.io.File;


/**
 * @ClassName: Main
 * @Description: 查询文件夹下所有文件的文件名集合
 * @auther: caiwei
 * @date: 2019/8/8 17:28
 */
public class Main {

    public static void main(String[] args){

        String url = "D:\\temp\\";
        File folder = new File(url);
        String[] fileNames = folder.list();
        for(String s : fileNames){
            System.out.println(s);
        }

        String filename = "caiwei.mp4";

        System.out.println(FilenameUtils.getExtension(filename));
        org.apache.log4j.Logger.getLogger("smslib");
        
    }
}
