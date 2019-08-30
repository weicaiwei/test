package others;

/**
 * @ClassName: others.Print
 * @Description: print工具类
 * @auther: caiwei
 * @date: 2019/4/17 16:15
 */
public class Print {


    public static void print(String msg) {
        System.out.print(msg);
    }

    public static void println() {
        System.out.println();
    }
    public static void println(String msg) {
        System.out.println(msg);
    }


    public static void main(String[] args) {

        System.out.println("结果是："+(log(5,10) -(log(2,10)/log(5,4)) ));
    }

    static  double log(double value, double base) {

        return Math.log(value) / Math.log(base);
    }
}
