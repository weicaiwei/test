package class_load_and_object_init;

/**
 * @ClassName: ClassLoadDemo
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/12/2 00:06
 */
public class ClassLoadDemo {

    public static void main(String[] args) {

        System.out.println("被启动（Bootstrap）类加载器加载的类的路径" + System.getProperty("sun.boot.class.path"));
        System.out.println("被扩展（Extension）类加载器加载的类的路径" + System.getProperty("java.ext.dirs"));
        System.out.println("系统（System）类加载器加载的类的路径" + System.getProperty("java.class.path"));


        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
    }
}