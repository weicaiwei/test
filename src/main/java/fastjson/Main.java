package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Main
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/8/6 14:27
 */
public class Main {

    public static void main(String[] args) {
        String peopleJsonString =
                "{'name':'wangpengda','age':'18','dogs':[{'name':'fugui'},{'name':'guihua'},{'name':'changhong'}]}";


        List<Dog> dogs = new ArrayList<>();
        Dog dog = new Dog();
        dog.setName("fugui");
        dogs.add(dog);
        People people = new People();
        people.setName("wangpengda");
        people.setAge("18");
        people.setDogs(dogs);


        People people1 = JSON.parseObject(peopleJsonString, People.class);

        JSONObject jsonObject = JSON.parseObject(peopleJsonString);
        System.out.println(jsonObject.toString());
        System.out.println(JSON.toJSONString(people1));


    }
}
