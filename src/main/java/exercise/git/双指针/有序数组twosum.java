package exercise.git.双指针;

public class 有序数组twosum {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
    public int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        int[] res = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        while(l < r){
            if (numbers[l] + numbers[r] == target) {
                res[0] = numbers[l];
                res[1] = numbers[r];
                return res;
            }else if (numbers[l] + numbers[r] < target){
                l++;
            }else{
                r--;
            }
        }
        return null;
    }
}
