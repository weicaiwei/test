package dom4j;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: Part
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/9/3 23:07
 */
@Data
public class Book {

    @XMLElement("part-total")
    private String partTotal;

    @XMLElement("part")
    private List<String> parts;
}
