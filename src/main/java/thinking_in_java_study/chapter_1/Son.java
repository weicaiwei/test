package thinking_in_java_study.chapter_1;

/**
 * @Name: Son
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/12/17 23:46
 */
public class Son extends Father {

    public void saySelf() {
        System.out.println("儿子自己说话话");
    }

    @Override
    public void sayToSon() {
        System.out.println("实际是儿子在说话");
    }


}
