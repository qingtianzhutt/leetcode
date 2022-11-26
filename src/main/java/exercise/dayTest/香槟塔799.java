package exercise.dayTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
我们把玻璃杯摆成金字塔的形状，其中 第一层 有 1 个玻璃杯， 第二层 有 2 个，依次类推到第 100 层，每个玻璃杯 (250ml) 将盛有香槟。
从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯。当左右两边的杯子也满了，就会等流量的流向它们左右两边的杯子，依次类推。（当最底层的玻璃杯满了，香槟会流到地板上）
例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。倾倒了两杯香槟后，第二层的两个玻璃杯各自盛放一半的香槟。在倒三杯香槟后，第二层的香槟满了 - 此时总共有三个满的玻璃杯。在倒第四杯后，第三层中间的玻璃杯盛放了一半的香槟，他两边的玻璃杯各自盛放了四分之一的香槟，如下图所示。
 */
public class 香槟塔799 {
    //自己写的方法 时间复杂度没通过。
    public double champagneTower(int poured, int query_row, int query_glass) {
        List<double[]> list = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            list.add(new double[i + 1]);
        }
        while(poured > 0){
            if (list.get(0)[0] < 1){
                list.get(0)[0] = 1;
            }else {
                fillCup(list, 0, 0, 1.0);
            }
            poured--;
        }
        return list.get(query_row)[query_glass];
    }
    private void fillCup(List<double[]> list, int row, int col, double vol){
        if (list.get(row + 1)[col] + vol / 2 <= 1.0) {
            list.get(row + 1)[col] += vol / 2;
        }else {
            list.get(row + 1)[col] = 1.0;
            fillCup(list, row + 1, col, list.get(row + 1)[col] + vol / 2 - 1.0);
        }
        if (list.get(row + 1)[col + 1] + vol / 2 <= 1.0) {
            list.get(row + 1)[col + 1] += vol / 2;
        }else {
            list.get(row + 1)[col + 1] = 1.0;
            fillCup(list, row + 1, col + 1, list.get(row + 1)[col + 1] + vol / 2 - 1.0);
        }
    }

    @Test
    public void test(){
        System.out.println(champagneTower2(4, 2, 0));
    }
    //直接动态规划来进行模拟。
    public double champagneTower2(int poured, int query_row, int query_glass) {
       double[][] dp = new double[query_row + 1][query_row + 1];
       dp[0][0] = poured;
       for (int i = 1; i <= query_row; i++){
           for (int j = 0; j <= i; j++){
               if (j != 0 && dp[i - 1][j - 1] > 1.0){
                   dp[i][j] += (dp[i - 1][j - 1] - 1.0) / 2;
               }
               if (j != i && dp[i - 1][j] > 1.0){
                   dp[i][j] += (dp[i - 1][j] - 1.0) / 2;
               }
           }
       }
       return Math.min(1, dp[query_row][query_glass]);
    }
}
