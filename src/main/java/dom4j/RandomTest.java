package dom4j;

import java.lang.reflect.Field;
import java.util.Collection;

/**
 * @ClassName: RandomTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/9/12 09:59
 */
public class RandomTest {

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = Part.class.getDeclaredField("testList");
        System.out.println("name:"+field.getName());
        Class tClass = field.getType();
        Class tClass2 = field.getClass();
        System.out.println("type" + field.getType() );
        if (Collection.class.isAssignableFrom(tClass)) {

            System.out.println("ok");
        }
        if (Collection.class.isAssignableFrom(tClass2)) {

            System.out.println("ok");
        }
    }
}
