package others;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GCTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/8/22 10:32
 */
public class GCTest {

    public static List<A> aList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        A a = new A("caiwei");
        System.out.println(a+";"+a.getName());
        A b = a;
        System.out.println(b+";"+b.getName());
        aList.add(a);
        System.out.println("aList.size=" + aList.size());
        a = null;
        System.out.println("aList.size=" + aList.size());
        for (A c : aList) {
            System.out.println("inaList"+c.getName());
        }
        Thread.sleep(10 * 1000);
        System.out.println(b+";"+b.getName());
    }
}
class A {
    private String name;

    public A(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}