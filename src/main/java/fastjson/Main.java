package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: Main
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/8/6 14:27
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(System.getProperty("jvm.name"));

        Dog[] dogs = new Dog[2];
        String peopleJsonString =
                "{'name':'wangpengda','age':'18','dogs':[{'name':'fugui'},{'name':'guihua'},{'name':'changhong'}]}";


        People people = new People();
        people.setName("wangpengda");
        people.setAge("18");


        People people1 = JSON.parseObject(peopleJsonString, People.class);

        JSONObject jsonObject = JSON.parseObject(peopleJsonString);
        System.out.println(jsonObject.toString());
        System.out.println(JSON.toJSONString(people1));


    }
}
