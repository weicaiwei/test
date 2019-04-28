package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 此例说明在纯计算的情况下，多线程没有意义，计算速度远比单线程慢。
 * 多线程主要是利用io等的阻塞等待时间，在某个线程阻塞时，其他线程还可以继续处理其他任务
 */

public class ArithmeticSpeed {

    private static int LIST_LENGTH = 1000*10000;
    private static int THREAD_NUMBER = 8;
    private static int SLICE_LENGTH = LIST_LENGTH/THREAD_NUMBER;

    /**
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("begin!");
        List<MyObject> list = new ArrayList<>();
        long now = System.currentTimeMillis();
        for(int i = 0; i<LIST_LENGTH;i++){
            list.add(new MyObject());
        }
        System.out.println("数组长度是"+list.size()+"  插入消耗时间是是"+(System.currentTimeMillis()-now)+"ms");

        //直接遍历
        int i = 0;
        now = System.currentTimeMillis();
        for(MyObject myObject : list){
            if (myObject.type == 2){
                i++;
            }
        }
        System.out.println("直接遍历，总共有"+i+"个对象,消耗时间是是"+(System.currentTimeMillis()-now)+"ms");

        //100个线程
        System.out.println("cpu核心数是 ："+Runtime.getRuntime().availableProcessors());
        int thread = Runtime.getRuntime().availableProcessors()*2;
        AtomicInteger atomicIntegerTime = new AtomicInteger(0);
        ExecutorService pool = Executors.newFixedThreadPool(thread);
        now = System.currentTimeMillis();
        for(int j =0; j < thread; j++ ){
            final int k = j;
            pool.execute(() ->{
                for(int l = k*SLICE_LENGTH; l < ((k+1)*SLICE_LENGTH); l++){
                    if(list.get(l).type  == 2){
                        atomicIntegerTime.addAndGet(1);
                    }
                }
            });
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("开线程池，总共有"+atomicIntegerTime+"个对象,消耗时间是是"+(System.currentTimeMillis()-now)+"ms");

    }
    static class MyObject{
        int type;
        public MyObject(){
            type = new Random().nextInt(100);
        }
    }

}

