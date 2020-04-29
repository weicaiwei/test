package class_load_and_object_init;

/**
 * @Name: Test
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/12/15 04:06
 */
public class Test {

    public String name = "采薇";
    private Son son =new Son();

    {
        System.out.println("执行构造代码块");

    }

    public Test() {
        System.out.println("执行构造函数");
        name = "母猪";
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.name);
    }
}
