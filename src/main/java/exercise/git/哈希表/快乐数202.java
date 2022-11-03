package exercise.git.哈希表;

import java.util.HashSet;
import java.util.Set;

public class 快乐数202 {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
    //自己写的，也很快
    public boolean isHappyNew(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = convert(n);
        }
        return n == 1;
    }
    private Integer convert(int n){
        int res = 0;
        while(n != 0){
            res += (n % 10) * (n % 10);
            n = n / 10;
        }
        return res;
    }
}
