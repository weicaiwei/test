package class_load_and_object_init;

/**
 * @ClassName: Main
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/12/1 21:38
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class fatherClass = Class.forName("class_load_and_object_init.Father");
        fatherClass.newInstance();
        Son son2 = new Son();
        System.out.println(ClassLoader.getSystemClassLoader());

        System.out.println(son2.getFatherName());
    }
}
