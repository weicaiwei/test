package dom4j;

import com.alibaba.fastjson.JSON;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * @ClassName: Main
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/9/3 15:29
 */
public class Main {


    public static void main(String[] args) throws Exception {

        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("D:\\temp\\xmltest_list.xml"));
        Element rootElement = document.getRootElement();
        Element book = rootElement.element("book");
        XMLService xmlService = new XMLService();
        Book p = xmlService.parseXmlElementToPojo(book, Book.class);
        System.out.println(JSON.toJSONString(p));


     }
}
