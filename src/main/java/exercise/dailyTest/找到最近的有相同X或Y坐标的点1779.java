package exercise.dailyTest;

import java.util.Arrays;
import java.util.Comparator;

public class 找到最近的有相同X或Y坐标的点1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int distance = Integer.MAX_VALUE;
        int xVal = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < points.length; i++){
            if (points[i][0] == x || points[i][1] == y){
                int tempDis = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (tempDis == distance){
                    if (points[i][0] < xVal){
                        xVal = points[i][0];
                        res = i;
                    }
                }else if (tempDis < distance){
                    distance = tempDis;
                    xVal = points[i][0];
                    res = i;
                }
            }
        }
        return res;
    }
}
