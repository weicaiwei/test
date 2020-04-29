package concurrent;

import com.alibaba.fastjson.JSON;

import java.util.UUID;

/**
 * @ClassName: AndOrTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/11/18 15:13
 */
public class AndOrTest {

    /**
     * @Title: main
     * @Description: TODO
     * @params: [args]
     * @return: void
     * @throws:
     *
    /**
     * @Title: main
     * @Description: TODO
     * @param args
     * @return: void
     * @throws:
     * @date: 2019/12/5 20:16
     */
    /*
     * @Title: main
     * @Description: TODO
     * @param args
     * @return: void
     * @throws:
     * @date: 2019/12/9 22:10
     */
    /**
     * @Title: main
     * @Description: TODO
     * @param args 参数
     * @return: void
     * @throws:
     * @date: 2019/12/9 22:12
     */
    public static void main(String[] args) {
        String uuid = String.valueOf(UUID.randomUUID());
        System.out.println(UUID.randomUUID().toString());

        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.fromString("33558243-3ed0-46d8-9e11-9333637c8a19"));

        int a, b, c, d;
        a = 1; b = 2;
        c = 3; d = 4;

        if (a > b & c > d) {
            System.out.println("hello");

        }


    }
}
