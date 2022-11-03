package exercise.git.动态规划.最长递增子序列;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 一组整数对能够构成的最长链 {
    public int findLongestChain(int[][] pairs) {
        //小顶堆
        PriorityQueue<int[]> smallPriorityQueue = new PriorityQueue<>(11, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < pairs.length; i++) {
            smallPriorityQueue.add(pairs[i]);
        }
        int[] s = smallPriorityQueue.remove();
        int res = 1;
        while(!smallPriorityQueue.isEmpty()){
            int[] remove = smallPriorityQueue.remove();
            if (remove[0] > s[1]) {
                res++;
                s = remove;
            }
        }
        return res;
    }
    //函数式接口，学会这种写法。
    public int findLongestChain2(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair: pairs) if (cur < pair[0]) {
            cur = pair[1];
            ans++;
        }
        return ans;
    }
    //动态规划做法
}
