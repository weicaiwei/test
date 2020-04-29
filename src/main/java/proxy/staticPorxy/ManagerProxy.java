package proxy.staticPorxy;

/**
 * @ClassName: ManagerProxy
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/11/26 17:21
 */
public class ManagerProxy implements Manager {

    private Manager manager;

    public ManagerProxy(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String doSomeThing() {
        System.out.println("代理方法做了某些事情");
        String targetReturn = manager.doSomeThing();
        System.out.println("代理方法结束啦");
        return targetReturn;
    }

}
