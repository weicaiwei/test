package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: Test
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/9/30 10:39
 */
public class Test {


    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        String word1 = "aaaa";
        String word2 = "bbbb";
        String word3 = "cccc";
        String word4 = "dddd";
        String word5 = "eeee";
        System.out.println(word1.hashCode());
        System.out.println(word2.hashCode());
        System.out.println(word3.hashCode());
        System.out.println(word4.hashCode());
        System.out.println(word5.hashCode());
        stringList.add(word5);
        stringList.add(word4);
        stringList.add(word3);
        stringList.add(word2);
        stringList.add(word1);
        System.out.println(stringList);
        stringList.sort(Comparator.comparingInt(String::hashCode));
        System.out.println(stringList);

    }
}
