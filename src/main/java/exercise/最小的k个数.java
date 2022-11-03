package exercise;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最小的k个数 {
    public static void main(String[] args) {
        int[] input = {1,23,4,5,6,778,2};
        int[] res = smallestK1(input,3);
        System.out.println(Arrays.toString(res));
    }
    //使用排序
    public static int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        for(int i = 0; i < k; i++){
            res[i] = arr[i];
        }
        return res;
    }
    //使用最大堆
    public static int[] smallestK1(int[] arr, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> pri = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                }
        );
        for(int i : arr){
            pri.offer(i);
        }
        int i = 0;
        while(k != 0){
            k--;
            res[i++] = pri.poll();
        }
        return res;
    }
    @Test
    public void test(){
        //o2 - o1是最大堆
        PriorityQueue<Integer> q = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                }
        );
        q.add(1);
        q.add(2);
        q.add(3);
        while (q.size() > 0) {
            System.out.println(q.poll());
        }
    }
}
