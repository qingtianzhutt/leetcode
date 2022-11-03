package exercise.暴力;

public class n皇后 {
    public static void main(String[] args) {
        int n = 9;
        int[] record = new int[n];
        int time = count(0, record, n);
    }



    //第k行元素设置
    public static int count(int k, int[] record, int n){
        if (k == n) {
            return 1;
        }
        //将当前行设置为第i列
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (judgeValid(k, i, record)) {
                record[k] = i;
                res += count(k + 1, record, n);
            }
        }
        return res;

    }
    //值传递还是引用传递
    public static boolean judgeValid(int k, int i, int[] record){
        for (int j = 0; j < k; j++) {
            if (record[j] == i || record[j] - i == j - k) {
                return false;
            }
        }
        return true;
    }
}
