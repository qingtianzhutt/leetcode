package exercise.区间求和;


import java.util.TreeSet;

/**
 * 我们枚举矩形的上下边界，并计算出该边界内每列的元素和，则原问题转换成了如下一维问题：
 * 给定一个整数数组和一个整数 kk，计算该数组的最大区间和，要求区间和不超过 kk。
 */
public class 矩形区域不超过K的最大数 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{2,3,4}};
        System.out.println(maxSumSubmatrix1(matrix,8));
    }
//    public static int maxSumSubmatrix(int[][] matrix, int k) {
//        int ret = Integer.MIN_VALUE;
//        //枚举矩形的上下边界
//        for(int i = 0; i < matrix.length; i++){
//            for (int j = i + 1; j < matrix.length; j++){
//                //计算每列元素的元素和
//                int[] res = new int[matrix[0].length];
//                for (int a = 0; a < matrix[0].length; a++){
//                    for (int b = i; b < j; b++){
//                        res[a] += matrix[a][b];
//                    }
//                }
//
//
//
//
//
//            }
//        }
//    }
    public static int maxSumSubmatrix1(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) { // 枚举下边界的同时更新每列元素的和并计算该数组的最大区间和。
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和，一列一列的更新
                }
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                //这个为了全匹配而存在的。
                sumSet.add(0);
                //s就是前n列的和。
                //前缀和的使用。
                int s = 0;
                for (int v : sum) {
                    s += v;
                    //celling的使用，ceiling(E e) 方法用来返回在此设定为大于或等于给定的元素的最小元素，或null，如果不存在这样的元素。
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }
    public int maxSumSubmatrix2(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i< matrix.length; i++){
            int[] columSum = new int[matrix[0].length];
            for(int j = i; j < matrix.length; j++){
                for(int a = 0; a < matrix[0].length; a++){
                    columSum[a] += matrix[j][a];
                }
                int matrixSum = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for(int v : columSum){
                    matrixSum += v;
                    if(set.ceiling(matrixSum - k) != null){
                        Integer value = set.ceiling(matrixSum - k);
                        res = Math.max(res, value);
                    }
                    set.add(matrixSum);
                }
            }
        }
        return res;
    }
}
