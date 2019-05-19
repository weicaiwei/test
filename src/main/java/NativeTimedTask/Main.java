package NativeTimedTask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName: Main
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/5/17 19:35
 */

public class Main {

    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new MyTimedTask(), 1000, 1000);
        System.out.println("怎么回事");

    }
    static class MyTimedTask extends TimerTask {

        @Override
        public void run() {
            System.out.println(" i im the timerTask' schedule job");
        }
    }
}

