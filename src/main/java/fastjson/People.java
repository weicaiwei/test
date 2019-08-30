package fastjson;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: People
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/8/6 14:27
 */
@Data
public class People {

    private String name;
    private String age;
    private List<Dog> dogs;
}
