package exercise.动态规划;

public class 爬楼梯70 {
    public static void main(String[] args) {

    }
    public static int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int p = 1, q = 2, temp, mod = 1000000007;
        int k = 3;
        while(k <= n){
            temp = p + q;
            p = q;
            q = temp;
            k++;
        }
        return q;
    }
}
