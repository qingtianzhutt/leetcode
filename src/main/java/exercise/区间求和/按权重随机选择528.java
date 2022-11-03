package exercise.区间求和;

import java.util.Arrays;

/**
 * 解题思路
 * 前缀和 + 二分查找
 */
public class 按权重随机选择528 {
    public static void main(String[] args) {
        int[] input = {1,3,4,6};
        Solution so = new Solution(input);
        System.out.println(so.pickIndex());
    }
}
class Solution {
    int[] pre;
    int total;

    public Solution(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; ++i) {
            pre[i] = pre[i - 1] + w[i];
        }
        total = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        //就是在1-total中随机选一个数，向下取整然后 + 1;
        int x = (int) (Math.random() * total) + 1;
        return binarySearch(x);
    }

    private int binarySearch(int x) {
        int low = 0, high = pre.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (pre[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
