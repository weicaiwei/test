package dom4j;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: XMLElement
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/9/4 09:32
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XMLElement {

    String value();
}


