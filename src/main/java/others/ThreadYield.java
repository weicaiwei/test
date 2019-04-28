package others;

/**
 * @ClassName: ThreadYield
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/4/18 20:29
 */
public class ThreadYield {

    public static void main(String[] args) {
        new Thread(new RunTask("采薇")).start();
        new Thread(new RunTask("caiwei")).start();

    }


    static class RunTask implements Runnable {

        private String name;

        public RunTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 40; i++) {
                Print.println(name+i);
                if (i == 25) {
                    //线程让步 当线程使用了这个方法之后，它就会把自己CPU执行的时间让掉，让自己或者其它的线程运行
                    Thread.yield();
                }
                Print.println(i + name);
            }

        }
    }


}
