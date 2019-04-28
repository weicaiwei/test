package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserFactory {
    public static User create() {
        User user = new User();
        Method[] methods = User.class.getMethods();
        Field[] fields = User.class.getDeclaredFields();
        try {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Init.class)) {
                    Init init = method.getAnnotation(Init.class);
                    method.invoke(user, init.value());
                }
            }
            for (Field field : fields) {
                if (field.isAnnotationPresent(Init.class)) {
                    field.setAccessible(true);
                    Init init = field.getAnnotation(Init.class);
                    field.set(user, init.value());
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return user;
    }
}
