package string;

import java.lang.reflect.Field;
import java.util.Base64;

/**
 * @ClassName: Main
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/9/19 22:17
 */
public class Main {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String shi = "夜深人静";
        String nullString = null;
        System.out.println("int类型转换成二进制字符串" + Integer.toBinaryString(10000000));

        System.out.println("int类型转换成16进制字符串" + Integer.toHexString(17));

        System.out.println("".equals(nullString));

        Class<String> stringClass = String.class;
        Field charArray = stringClass.getDeclaredField("value");
        charArray.setAccessible(true);
        char[] chars = (char[]) charArray.get(shi);

        System.out.println(shi.length());

        System.out.println(chars.length);

        for (char c : chars) {
            System.out.println(c);
        }

        int a = -1;
        int b = 5;
        System.out.println(Integer.toBinaryString(a));

        System.out.println(Integer.toBinaryString(b));
        System.out.println(Character.toChars(1));
    }
}
