package exercise.git.双指针;

public class 两数平方和 {
    public boolean judgeSquareSum(int c) {
        long l = 0;
        long r = (long)Math.sqrt(c);
        while(l <= r){
            long sum = l * l + r * r;
            if (c == sum) {
                return true;
            }else if(c < sum){
                r--;
            }else{
                l++;
            }
        }
        return false;
    }
}
