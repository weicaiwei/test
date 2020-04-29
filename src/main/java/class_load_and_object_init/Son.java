package class_load_and_object_init;

/**
 * @ClassName: Son
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/12/1 21:36
 */
public class Son extends Father {


    static {
        System.out.println("执行子类静态代码块");
    }

    //Son son = new Son()//变成.class文件时，会把这个初始化编译到构造函数中，一样会导致递归调用导致栈内存溢出

    public Son() {
        //new Son();会导致递归调用导致栈内存溢出
        System.out.println("子类初始化");


    }

    public Son(String name) {
        System.out.println("赋予了名字：" + name);
    }
}
