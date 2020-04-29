package proxy.dynamicProxy;

/**
 * @ClassName: Car
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/11/26 17:31
 */
public class Car implements Moveable {

    @Override
    public String move() {
        System.out.println("被代理的车车行驶中");
        return "hello world";
    }

}
