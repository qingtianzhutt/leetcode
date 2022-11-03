package exercise.动态规划;

public class 使用最小花费爬楼梯746 {
    public static void main(String[] args) {

    }
    public static int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0) return 0;
        int len = cost.length;
        int p = 0, q = 0, temp;
        int k = 2;
        while(k <= len){
            temp = Math.min(p + cost[k - 2], q + cost[k - 1]);
            p = q;
            q = temp;
            k++;
        }
        return q;
    }
}
