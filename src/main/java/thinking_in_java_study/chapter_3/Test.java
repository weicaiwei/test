package thinking_in_java_study.chapter_3;

/**
 * TODO
 *
 * @auther caiwei
 * @date 2019-12-19
 */
public class Test {

    public static void main(String[] args) {
        /*int i = 0;
        System.out.println(i++);
        System.out.println(i);*/

        int j = 0;
        for (;j< 2; j++) {
            System.out.println("j:" + j);
        }
        System.out.println("for循环之后，j:" + j);
    }
}
