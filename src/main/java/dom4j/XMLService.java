package dom4j;

import lombok.extern.java.Log;
import org.dom4j.Element;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName: XMLService
 * @Description: 解析xml节点为pojo
 * @auther: caiwei
 * @date: 2019/9/3 23:44
 */
@Log
public class XMLService {

    public <T> T parseXmlElementToPojo(Element element, Class<T> tClass) throws Exception {
        T tObject = tClass.newInstance();
        Field[] fields = tClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String elementName;
            if (field.isAnnotationPresent(XMLElement.class)) {
                elementName = field.getAnnotation(XMLElement.class).value();
            }else {
                elementName = field.getName();
            }
            @SuppressWarnings("unchecked")
            List<Element> childElements = element.elements(elementName);
            //该节点不存在
            if (childElements.size() == 0) {
                log.info("field:"+field.getName()+"没有找到对应的xml节点");
            } else if (childElements.size() == 1){
                //该节点不是集合
                field.set(tObject, childElements.get(0).getText());
            } else {
                //该节点是个集合
                //判断属性是否是个集合
                if(!Collection.class.isAssignableFrom(field.getType())){
                    throw new Exception("the xml node is a list, but the field is not a list");
                }
                List<String> listField = new ArrayList<>();
                for(Element childElement: childElements){
                    listField.add(childElement.getText());
                }
                field.set(tObject, listField);
            }

        }
        return tObject;
    }
}
