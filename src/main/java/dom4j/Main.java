package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @ClassName: Main
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/9/3 15:29
 */
public class Main {


    public static void main(String[] args) throws DocumentException {

        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("D:\\temp\\xmltest.xml"));
        Element rootElement = document.getRootElement();
        Element childBookElement = rootElement.element("book");
        List<Element> childs1 = childBookElement.elements("part");
        Element partElement = childs1.get(0);
        XMLService xmlService = new XMLService();
        Part p = xmlService.parseXmlElementToJavaBean(partElement, Part.class);
        System.out.println(p);


    }
}
