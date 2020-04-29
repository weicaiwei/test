package others;


import org.apache.commons.lang.exception.ExceptionUtils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @ClassName: ReturnTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/8/7 17:42
 */
public class ReturnTest {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        String name = "1";
          System.out.println(stringReturn(name));

    }

    static String stringReturn(String name) {
        try {
            throw new IOException();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(ExceptionUtils.getFullStackTrace(e));

        }
        if(name.equals("1")){
            return "到此为止了";
        }
        return "继续往下走了";
    }

}