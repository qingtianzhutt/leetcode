package exercise.git.贪心算法;

import java.util.Arrays;
import java.util.LinkedList;

public class 根据身高重建队列406 {
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1],p);
        }
        return que.toArray(new int[people.length][]);
    }

    public int[][] reconstructQueue2(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        LinkedList<int[]> que = new LinkedList<>();
        //这里就是链表和数组的不同了，链表插到同一个位置，之前的位置会被取消掉。
        for (int[] p : people) {
            que.add(p[1],p);
        }
        //将List变为数组的方法。
        return que.toArray(new int[people.length][]);
    }
}
