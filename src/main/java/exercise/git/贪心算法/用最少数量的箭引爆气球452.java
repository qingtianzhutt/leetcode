package exercise.git.贪心算法;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

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

}
