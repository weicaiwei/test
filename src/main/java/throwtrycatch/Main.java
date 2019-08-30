package throwtrycatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @ClassName: Main
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/8/19 21:40
 */
public class Main {
    public static void main(String[] args) {

        try {
            runTimeException();
            System.out.println("ONE");
            File file = new File("D:\\temp\\");
            if(file.exists()){
                try {
                    OutputStream outputStream = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            };
            try {
                chufa(1, 0);
            } catch (Exception e) {
                StackTraceElement stackTraceElement= e.getStackTrace()[0];
                System.out.println("File="+stackTraceElement.getFileName());
                System.out.println("Line="+stackTraceElement.getLineNumber());
                System.out.println("Method=" + stackTraceElement.getMethodName());
            }
            System.out.println("TWO");

        } catch (Exception e) {
            System.out.println("进到catch中来了");
            e.printStackTrace();

        }


    }

    public static int chufa(Integer a, Integer b) throws Exception {

        if (b.equals(0)) {
            throw new Exception();
        } else {
            return a / b;
        }
    }

    public static void runTimeException() {
        System.out.println("cawei");
        
        throw new RuntimeException("运行时异常");


    }
}
