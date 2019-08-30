package others;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: ReferenceTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/8/29 09:08
 */
public class ReferenceTest {

    private ExecutorService threadPool = Executors.newFixedThreadPool(50);


    private StudentA a;

    public void setStudentA(StudentA a) {
        this.a = a;
    }


    public StudentA getStudentA() {
        return a;
    }

    public String getStudentAName() {
        return a.getName();
    }


    public void sayAName() {
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(new Random().nextInt(1000));
                    System.out.println("thread" + Thread.currentThread().getName() + "a的名字：" +
                            a.getName() + "a.addr" + a.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    public static void main(String[] args) throws InterruptedException {
        ReferenceTest test = new ReferenceTest();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(new Random().nextInt(1000));

            test.setStudentA(new StudentA(String.valueOf(new Random().nextInt(1000))));
            System.out.println(("thread:" + Thread.currentThread().getName() + "name" + test.getStudentAName()) + "a.addr" + test.getStudentA().toString());
            test.sayAName();

        }
    }



}

class StudentA {
    String name;

    public StudentA(String name) {

        this.name = name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

}