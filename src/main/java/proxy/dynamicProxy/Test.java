package proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ClassName: Test
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/11/26 17:37
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        InvocationHandler invocationHandler = new TimeHandler(car);
        Class carClass = car.getClass();

        Moveable moveable = (Moveable) Proxy.newProxyInstance(carClass.getClassLoader(), carClass.getInterfaces(), invocationHandler);
        String result = moveable.move();
        System.out.println(result);

    }
}
