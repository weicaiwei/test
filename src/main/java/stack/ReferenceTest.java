package stack;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @ClassName: Reference
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/8/30 16:03
 */
public class ReferenceTest {


    public static void main(String[] args) {
        Reference reference = new WeakReference<>(new Person("caiwei"));

        System.out.println("GC前："+((Person) reference.get()).getName());

        System.gc();
        System.out.println("GC后："+((Person) reference.get()).getName());
    }



}
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
