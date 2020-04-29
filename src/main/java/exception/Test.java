package exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: Test
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/11/27 20:47
 */
@Slf4j
public class Test {


    public static void main(String[] args) throws Custom2Exception {
        Student caiwei = new Student();
        //caiwei.ask_1("脏话");
        try {
            caiwei.ask_3("还在说脏话");

        } catch (OhterException e) {
            log.error("异常", e);
         /*   log.error("异常：" + e);*/
/*            System.out.println(
                    e.getStackTrace()[0].getFileName() + "\n" +
                            e.getStackTrace()[0].getClassName() + "\n" +
                            e.getStackTrace()[0].getMethodName() + "\n" +
                            e.getStackTrace()[0].getLineNumber() + "\n" +
                            e);
            e.printStackTrace();*/
        }
    }
}
