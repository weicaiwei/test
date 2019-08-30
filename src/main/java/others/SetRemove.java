package others;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: SetRemove
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/8/24 19:44
 */
public class SetRemove {

    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();
        Student a = new Student("caiwei");
        Student b = a;
        System.out.println(a);
        System.out.println(b);
        students.add(a);

        System.out.println(students.size());

        students.remove(b);
        System.out.println(students.size());

    }
}
class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

}