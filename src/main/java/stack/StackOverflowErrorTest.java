package stack;

/**
 * @ClassName: StackOverflowErrorTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/8/29 21:43
 */
public class StackOverflowErrorTest {


    static int i = 0;

    public static void main(String[] args) {
        try {
            i++;
            cycle();
        } catch (Exception e) {
        }finally {
            System.out.println(i);
        }


    }

    static void cycle() {

        i++;
        cycle();
    }

}
