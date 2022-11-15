package exercise.git.贪心算法;

import org.junit.Test;

import java.util.Arrays;

/*
老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
你需要按照以下要求，帮助老师给这些孩子分发糖果：
每个孩子至少分配到 1 个糖果。
相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？
输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
输入: [1,2,2]
输出: 4
解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
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
    //一次通过。
    public int candy1(int[] ratings) {
        int[] count = new int[ratings.length];
        count[0] = 1;
        for (int i = 1; i < ratings.length; i++){
            count[i] = ratings[i] > ratings[i - 1] ? count[i - 1] + 1 : 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--){
            if (ratings[i] > ratings[i + 1]) {
                count[i] = Math.max(count[i], count[i + 1] + 1);
            }
        }
        return Arrays.stream(count).sum();
    }
}
