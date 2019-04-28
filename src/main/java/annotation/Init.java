package annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {

    String value() default "caiwei";

}
