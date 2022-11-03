package exercise.动态规划;

public class 第N个斐波那契数1137 {
    public static void main(String[] args) {

    }
    public static int tribonacci(int n) {
        if(n < 2)return n;
        if(n == 2)return 1;
        int p = 0, q = 1, r = 1, temp, mod = 1000000007;
        int k = 3;
        while(k <= n){
            temp = p + q + r;
            p = q;
            q = r;
            r = temp;
            k++;
        }
        return r;
    }
}
