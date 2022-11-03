package exercise.快速排序;

public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,3,6,78,67};
        process(arr, 0, arr.length - 1);
        for (int i : arr){
            System.out.println(i);
        }
    }
    public static void process(int[] arr, int l, int r){
        if (l == r){
            return;
        }
        int num = arr[r];
        //令中间有序并且得到分隔成两个区域的边界
        int[] partition = partition(arr, num);
        //令左边有序
        process(arr, l, partition[0]);
        //令右边有序
        process(arr, partition[1], r);
    }
    //荷兰军旗进阶版，分为三个区域。
    public static int[] partition(int[] arr, int num){
        int[] res = new int[2];
        int lLimit = 0;
        int rLimit = arr.length - 1;
        int i = 0;
        //循环结束后lLimit和rLimit将数组切分开。
        while(i <= rLimit){
            if (arr[i] < num){
                swap(arr, i, lLimit);
                lLimit++;
                i++;
            }else if (arr[i] > num){
                swap(arr, i, rLimit);
                rLimit--;
            }else{
                i++;
            }
        }
        res[0] = lLimit;
        res[1] = rLimit;
        return res;
    }
    public static void swap(int[] arr, int source, int target){
        int temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;
    }
}
