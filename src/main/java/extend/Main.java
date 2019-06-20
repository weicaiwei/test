package extend;

/**
 * @ClassName: Main
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/6/12 20:10
 */
public class Main {

    public static void main(String[] args) {
        Son1 son1 = new Son1();
        son1.setId("1");
        son1.setLove("chishi");
        son1.setName("caiwei");
        son1.setSonName("采薇");
        System.out.println("id:"+son1.getId());
        System.out.println("love:"+son1.getLove());
        System.out.println("id:"+son1.getName());
        System.out.println("id:"+son1.getSonName());
        System.out.println(son1.toString());

    }
}
