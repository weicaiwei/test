package proxy.staticPorxy;

/**
 * @ClassName: ManagerImp
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/11/26 17:20
 */
public class ManagerImp implements Manager {

    @Override
    public String doSomeThing() {
        System.out.println("原对象做了某些事情");
        return "hello world";
    }

}
