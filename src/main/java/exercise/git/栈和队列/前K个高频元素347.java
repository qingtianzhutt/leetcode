package exercise.git.栈和队列;

import org.junit.Test;

import java.util.*;

//前 K 个高频元素
//priorityQueue默认小根堆。   类比为  默认为从小到大排列。
public class 前K个高频元素347 {
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //默认是大根堆还是小根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
           queue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        for (int i: topKFrequent1(nums, k)){
            System.out.println(i);
        }

    }
}
