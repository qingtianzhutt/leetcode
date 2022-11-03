package exercise.区间求和;

import java.util.Arrays;

/**
 * 最好的方法是构建差分数组。
 */
public class 预定航班统计1109 {
    public static void main(String[] args) {
        int [][] array = {{1,9,7},{1,3,6},{7,8,1}};
        System.out.println(Arrays.toString(count(array, 9)));
    }
    public static int[] count(int[][] input, int n){
        int[] res = new int[n];
        for (int i = 0; i < input.length; i++){
            for(int j = input[i][0] - 1; j <= input[i][1] - 1; j++){
                res[j] += input[i][2];
            }
        }
        return res;
    }
    //使用差分数组解决问题
    public static int[] count2(int[][] input, int n){
        int[] res = new int[n];
        for(int i = 0; i < input.length; i++){
            res[input[i][0] - 1] += input[i][2];
            if(input[i][1] < n){
                res[input[i][1]] += input[i][2];
            }
        }
        for(int i = 1; i < res.length; i++){
            res[i] += res[i - 1];
        }
        return res;
    }
}



