package dom4j;

import lombok.extern.java.Log;
import org.dom4j.Element;

import java.lang.reflect.Field;

/**
 * @ClassName: XMLService
 * @Description: 解析xml节点为javaBean
 * @auther: caiwei
 * @date: 2019/9/3 23:44
 */
@Log
public class XMLService {

    public <T> T parseXmlElementToJavaBean(Element element, Class<T> tClass) {
        T tObject = null;
        try {
            tObject = tClass.newInstance();
            Field[] fields = tClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String elementValue = element.elementText(field.getName());
                if (null != elementValue) {
                    field.set(tObject, elementValue);
                } else {
                    log.info("field:"+field.getName()+"没有找到对应的xml节点");
                }


            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return tObject;
    }
}
