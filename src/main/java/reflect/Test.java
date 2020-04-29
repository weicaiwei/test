package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName: Test
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/11/21 18:48
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> teacherClass1 = Class.forName("reflect.Teacher");
        Class<?> teacherClass2 = Teacher.class;
        Teacher wang = new Teacher("老王");
        Method method1 = teacherClass1.getMethod("hit2", String.class);
        String what = (String) method1.invoke(wang, "hello");
        System.out.println(what);

    }
}
