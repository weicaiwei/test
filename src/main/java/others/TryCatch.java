package others;

/**
 * @ClassName: TryCatch
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/8/19 17:18
 */
public class TryCatch {

    public static void main(String[] args)  {


        try {
            test1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("d");
    }

    private static void test1() throws Exception {
        throw new Exception();
    }
    private static void test2() throws Exception {
        throw new Exception();
    }
    private static void test3() throws Exception {
        throw new Exception();
    }
    private static void test4() throws Exception {
        throw new Exception();
    }
}
