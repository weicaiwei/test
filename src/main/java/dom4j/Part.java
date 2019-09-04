package dom4j;

import lombok.Data;

/**
 * @ClassName: Part
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/9/3 23:07
 */
@Data
public class Part {
    private String id;
    @XMLElement("name")
    private String name;
    @XMLElement("author")
    private String author;
    @XMLElement("year")
    private String year;
    @XMLElement("price_un")
    private String price;
}
