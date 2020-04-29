package proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName: TimeHandler
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/11/26 17:32
 */
public class TimeHandler implements InvocationHandler {

    private Moveable moveable;

    public TimeHandler(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶");
        Object object = method.invoke(moveable, args);
        long stopTime  = System.currentTimeMillis();
        System.out.println("汽车结束行驶…汽车行驶时间：" + (stopTime - startTime) + "毫秒！");
        return object;
    }

}
