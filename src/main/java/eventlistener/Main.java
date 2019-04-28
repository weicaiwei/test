package eventlistener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Teacher teacherWang = new TeacherImpl();
        Student xiaoming = new StudentImpl("小明", teacherWang);
        Student laowang = new StudentImpl("老王", teacherWang);
        Student zhangsan = new StudentImpl("张三", teacherWang);
        Student lisi = new StudentImpl("李四", teacherWang);
        Student wangwu = new StudentImpl("王五", teacherWang);

        ExecutorService executorPool = Executors.newFixedThreadPool(10);

        executorPool.execute(()->{xiaoming.doingHomework();xiaoming.handInHomework();});
        executorPool.execute(()->{laowang.doingHomework();laowang.handInHomework();});
        executorPool.execute(()->{zhangsan.doingHomework();zhangsan.handInHomework();});
        executorPool.execute(()->{lisi.doingHomework();lisi.handInHomework();});
        executorPool.execute(()->{wangwu.doingHomework();wangwu.handInHomework();});

        executorPool.execute(teacherWang::checkHomework);

        executorPool.shutdown();
        executorPool.awaitTermination(1, TimeUnit.DAYS);
        xiaoming.lookScore();
        laowang.lookScore();
        zhangsan.lookScore();
        lisi.lookScore();
        wangwu.lookScore();


    }
}
