package others;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: JsonSerial
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/8/28 10:38
 */
public class JsonSerial {

     public static void main(String[] args) {

        Student a = new Student("caiwei", "15");
        Student b = new Student("gongmaolei", "16");
        Student c = new Student("sunguangju", "17");
        String jsona = JSON.toJSONString(a);
        String jsonb = JSON.toJSONString(b);
        String jsonc = JSON.toJSONString(c);
        List<String> stringList = new ArrayList<>();
        stringList.add(jsona);
        stringList.add(jsonb);
        stringList.add(jsonc);
        String jsonString = JSON.toJSONString(stringList);
        System.out.println(jsonString);

    }

    @Data
    static class Student{
        String name;
        String age;

        public Student(String name, String age) {
            this.name = name;
            this.age = age;
        }
    }
}
