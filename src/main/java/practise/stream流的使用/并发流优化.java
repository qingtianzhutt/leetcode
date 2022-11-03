package practise.stream流的使用;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class 并发流优化 {
    private final static Random random = new Random();
    static class WorkTask implements Runnable{
        private JSONArray jsa;
        private Integer id;
        private CountDownLatch latch;

        public WorkTask(JSONArray jsa, Integer id, CountDownLatch latch){
            this.jsa = jsa;
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            jsa.add("qintaozhi");
            System.out.println("开始寻找" + id + "号龙珠" + Thread.currentThread());
            //random就是个随机数。
            int seconds = random.nextInt(100);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("花了" + seconds + "s,找到了" + id + "号龙珠");
            //告知任务到这处理结束
            latch.countDown();
        }
    }
    public static void main(String[] args){

        //把forkjoin放在外面效率更高一点 。
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "40");
        List<List<Integer>> list = new ArrayList<>();
        list.add(Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20).collect(toList()));
        list.add(Stream.of(11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30).collect(toList()));
        long start = new Date().getTime();
        List<Integer> list2 = Stream.of(1,2,3,4,5,6,7).collect(toList());
        CountDownLatch latch = new CountDownLatch(list2.size());
        JSONArray jsa = new JSONArray();
        for (Integer id : list2){
            Thread thread = new Thread(new WorkTask(jsa , id, latch));
            thread.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(jsa);


//        list.parallelStream().forEach(lit ->{
//            try {
//                Thread.sleep(4000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(lit.toString() + Thread.currentThread());
//
//            lit.parallelStream().forEach(a -> {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(a.toString() + Thread.currentThread());
//            });
//
//        });
        long end = new Date().getTime();
        System.out.println(end - start);

    }
}
