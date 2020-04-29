package javadoc;

import java.io.IOException;

/**
 * javadoc使用 测试类
 *
 * @author caiwei
 * @date 2019-12-19
 */
public class JavaDocTest {

    /**
     * 母猪
     */
    String name;

    /**
     * javadoc测试方法
     *
     * @param name 名称
     * @param age 年龄
     * @param isGood 是否好样的
     * @return 运算结果
     * @throws IOException -io异常
     * @throws RuntimeException -运行时异常
     */
    public String hello(String name, int age, Boolean isGood) throws IOException,RuntimeException {

        return "hello";
    }
}
