package others;

/**
 * @ClassName: ReturnTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/8/7 17:42
 */
public class ReturnTest {

    public static void main(String[] args) {

        String name = "1";
          System.out.println(stringReturn(name));

    }

    static String stringReturn(String name) {
        if(name.equals("1")){
            return "到此为止了";
        }
        return "继续往下走了";
    }

}