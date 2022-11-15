package exercise.git.贪心算法;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
/*
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
注意: 可以认为区间的终点总是大于它的起点。 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
输入: [ [1,2], [2,3], [3,4], [1,3] ]
输出: 1
解释: 移除 [1,3] 后，剩下的区间没有重叠。
输入: [ [1,2], [1,2], [1,2] ]
输出: 2
解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
输入: [ [1,2], [2,3] ]
输出: 0
解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class 无重叠区间435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            // 按照区间右边界升序排序
            return a[1] - b[1];
        });

        int count = 0;
        int edge = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            // 若上一个区间的右边界小于当前区间的左边界，说明无交集
            if (edge <= intervals[i][0]) {
                edge = intervals[i][1];
            } else {
                count++;
            }
        }

        return count;
    }
    //通过了。
    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int r = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= r) {
                r = intervals[i][1];
            }else {
                res++;
                r = Math.min(intervals[i][1], r);
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[][] nums = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals2(nums));
    }

    //一次通过。
    public int eraseOverlapIntervals4(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int res = 0;
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] > intervals[i][0]){
                res++;
            }else{
                temp = intervals[i];
            }
        }
        return res;
    }
}
