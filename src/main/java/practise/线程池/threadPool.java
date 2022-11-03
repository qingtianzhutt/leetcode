package practise.线程池;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class threadPool {
    public static void main(String[] args) {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 5, TimeUnit.SECONDS, new SynchronousQueue<>());
//        for (int i = 0; i < 1000; i++){
//            executor.submit(() -> {
//                System.out.println(1);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 600000; i++){
            list.add(i);
        }
        list.parallelStream().forEach(i ->{
            System.out.println(i);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
