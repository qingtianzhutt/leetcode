package exercise.dailyTest;

import org.junit.Test;

/*
一个正整数如果能被 a 或 b 整除，那么它是神奇的。
给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 109 + 7 取模 后的值。
 */
public class 第N个神奇数字878 {
    static final int MOD = 1000000007;
    public int nthMagicalNumber(int n, int a, int b) {
        long end = (long) n * Math.min(a, b);
        long l = Math.min(a, b), r = end;
        long c = lcm(a, b);
        while(l < r){
            long mid = (l + r) / 2;
            long count = mid / a + mid / b - mid / c;
            if (count == n){
                return (int)(mid % MOD);
            }else if (count < n){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return (int)l;
    }
    private long lcm(int a, int b){
        return a * b / gcm(a, b);
    }
    private long gcm(int a, int b){
        return b != 0 ? gcm(b, a % b) : a;
    }

    @Test
    public void test(){
        System.out.println(nthMagicalNumber(4, 2, 3));
    }
}
