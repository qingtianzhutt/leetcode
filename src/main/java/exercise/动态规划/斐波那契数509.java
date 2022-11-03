package exercise.动态规划;

public class 斐波那契数509 {
    public static void main(String[] args) {

    }
    public static int fib(int n) {
        if(n < 2)return n;
        int p = 0, q = 1, mod = 1000000007, temp;
        int k = 2;
        while(k <= n){
            temp = (p + q)%mod;
            p = q;
            q = temp;
            k++;
        }
        return q;
    }
}
