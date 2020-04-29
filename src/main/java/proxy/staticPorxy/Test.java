package proxy.staticPorxy;

/**
 * @ClassName: Test
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/11/26 17:24
 */
public class Test {

    public static void main(String[] args) {
        ManagerProxy managerProxy = new ManagerProxy(new ManagerImp());
        System.out.println(managerProxy.doSomeThing());
    }
}
