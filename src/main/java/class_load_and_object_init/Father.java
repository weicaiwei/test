package class_load_and_object_init;

/**
 * @ClassName: Father
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/12/1 21:32
 */

public class Father {


    private String fatherName = "我是爹";

    static {
        System.out.println("执行父类静态代码块");
    }

    public Father() {
        System.out.println("父类初始化");
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
}
