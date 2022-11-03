package practise.forkjoin;

import java.util.stream.LongStream;

public class forkjointest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Long sum = LongStream.rangeClosed(0L, 10000000000L).parallel().sum();
        System.out.println(sum);

        long end = System.currentTimeMillis();
        System.out.println("耗费的时间为: " + (end - start)); // 2061-2053-2086-18926
    }
}
