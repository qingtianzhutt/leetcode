package exercise.git.贪心算法;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
/*
在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
输入：points = [[10,16],[2,8],[1,6],[7,12]]
输出：2
解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 */
public class 用最少数量的箭引爆气球452 {
    public int findMinArrowShots(int[][] points) {
        // 根据气球直径的开始坐标从小到大排序
        // 使用Integer内置比较方法，不会溢出
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 1;  // points 不为空至少需要一支箭
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {  // 气球i和气球i-1不挨着，注意这里不是>=
                count++; // 需要一支箭
            } else {  // 气球i和气球i-1挨着
                points[i][1] = Math.min(points[i][1], points[i - 1][1]); // 更新重叠气球最小右边界
            }
        }
        return count;
    }

    public int findMinArrowShots2(int[][] points) {
        //这种写法在数字超出一定范围时，会有问题。比如test方法中的问题。
//        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        Deque<int[]> list = new LinkedList<>();
        for (int[] single : points){
            list.add(single);
        }
        int res = 0;
        while(list.size() != 0){
            int[] poll = list.poll();
            while(!list.isEmpty() && poll[1] >= list.peek()[0]){
                list.remove();
            }
            res++;
        }
        return res;
    }

    @Test
    public void test(){
        //这里应该是负数，但是超出数字的限制反而会变成 正数。
        int[][] nums = {{-2147483646,-2147483645}, {2147483646,2147483647}};
        System.out.println(findMinArrowShots2(nums));
        int a = -2147483645;
        int b = 2147483647;
        int i = a - b;
        System.out.println(i);
    }

    //一次通过。
    public int findMinArrowShots4(int[][] points) {
        // 根据气球直径的开始坐标从小到大排序
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int res = 1;
        int row = points[0][1];
        for (int[] array : points){
            if (row < array[0] || row > array[1]){
                res++;
                row = array[1];
            }
        }
        return res;
    }

}
