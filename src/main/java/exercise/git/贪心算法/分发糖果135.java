package exercise.git.贪心算法;

import org.junit.Test;

public class 分发糖果135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candyVec = new int[len];
        candyVec[0] = 1;
        for (int i = 1; i < len; i++) {
            candyVec[i] = (ratings[i] > ratings[i - 1]) ? candyVec[i - 1] + 1 : 1;
        }

        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
        }

        int ans = 0;
        for (int num : candyVec) {
            ans += num;
        }
        return ans;
    }
    //自己的简陋的方法
    public int candy2(int[] ratings) {
        int[] count = new int[ratings.length];
        int i = 0;
        while(i < ratings.length){
            int k = i;
            int len = 0;
            if (k < ratings.length - 1 && ratings[k] > ratings[k + 1]){
                while(k < ratings.length - 1 && ratings[k] > ratings[k + 1]){
                    len++;
                    k++;
                }
                while(i <= k){
                    count[i] = i != 0 && ratings[i] > ratings[i - 1] ? Math.max(count[i - 1] + 1, len-- + 1) : len-- + 1;
                    i++;
                }
            } else if (k == 0 || ratings[k] == ratings[k - 1]){
                count[i++] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                i++;
            }

        }
        int res = 0;
        for (int j : count){
            res += j;
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {1,3,4,5,2};
        System.out.println(candy2(nums));
    }
}
