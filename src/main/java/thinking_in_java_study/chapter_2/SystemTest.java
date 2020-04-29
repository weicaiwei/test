package thinking_in_java_study.chapter_2;

import java.io.IOException;
import java.util.Properties;

/**
 * @Name: SystemTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/12/18 23:11
 */
public class SystemTest {
    public static void main(String[] args) {

        System.getProperties().list(System.out);
        Properties properties = new Properties();
        try {
            properties.load(Class.forName("thinking_in_java_study.chapter_2.SystemTest").getResourceAsStream("/param.properties"));

        } catch (IOException e) {
            System.out.println("未找到");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("name" + properties.getProperty("name"));
        System.out.println("age" + properties.getProperty("age"));


        System.out.println(System.getProperty("user.name"));

    }
}
