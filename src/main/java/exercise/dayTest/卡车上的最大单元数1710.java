package exercise.dayTest;

import java.util.Arrays;
import java.util.Comparator;

/*
请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
numberOfBoxesi 是类型 i 的箱子的数量。
numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
返回卡车可以装载 单元 的 最大 总数。
 */
//太简单了，直接排列就行了,4分钟，直接通过。
public class 卡车上的最大单元数1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        if (boxTypes == null || boxTypes.length == 0) return 0;
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> a[1]));
        int res = 0;
        for (int i = boxTypes.length - 1; i >= 0 && truckSize > 0; i--) {
            if (truckSize >= boxTypes[i][0]){
                res += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            }else {
                res += truckSize * boxTypes[i][1];
                return res;
            }
        }
        return res;
    }
}
