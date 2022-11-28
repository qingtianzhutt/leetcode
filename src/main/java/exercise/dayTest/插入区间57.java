package exercise.dayTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class 插入区间57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        if (intervals == null && newInterval == null){
            return null;
        }else if (intervals == null){
            list.add(newInterval);
        }else if (newInterval == null){
            for (int[] interval : intervals) {
                list.add(interval);
            }
        }else if (newInterval[0] > intervals[intervals.length - 1][1]){
            for (int[] interval : intervals) {
                list.add(interval);
            }
            list.add(newInterval);
        }else if (newInterval[1] < intervals[0][0]){
            list.add(newInterval);
            for (int[] interval : intervals) {
                list.add(interval);
            }
        }else {
            int newStart = -1, newEnd = -1, startIndex = -1, endIndex = -1;
            for (int i = 0; i < intervals.length; i++){
                if (newInterval[0] <= intervals[i][1]){
                    newStart = Math.min(newInterval[0], intervals[i][0]);
                    startIndex = i;
                    break;
                }
            }
            for (int j = startIndex; j < intervals.length; j++){
                if (newInterval[1] < intervals[j][0]){
                    endIndex = j - 1;
                    newEnd = Math.max(newInterval[1], intervals[j - 1][1]);
                    break;
                }
            }
            if (endIndex == -1){
                endIndex = intervals.length;
                newEnd = newInterval[1];
            }
            for (int i = 0; i < intervals.length; i++){
                if (i < startIndex || i > endIndex){
                    list.add(intervals[i]);
                }
            }
            list.add(startIndex, new int[]{newStart, newEnd});
        }
        return list.toArray(new int[list.size()][]);
    }

    @Test
    public void test(){
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        System.out.println(insert(intervals, newInterval));
    }
}
