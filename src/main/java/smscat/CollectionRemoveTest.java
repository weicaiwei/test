package smscat;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName: CollectionRemoveTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/9/25 22:57
 */
public class CollectionRemoveTest {

    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("cai");
        System.out.println(collection.remove("cai"));
    }
}
