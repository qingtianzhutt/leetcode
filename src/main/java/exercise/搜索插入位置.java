package exercise;

/**
 * 二分法的使用。
 */
public class 搜索插入位置 {
    public static void main(String[] args) {
        int[] a = {1,3,5,7,9};
        int target = 10;
        System.out.println(method3(a,target));


    }

    /**
     * 最简单的二分
     * @param nums
     * @param target
     * @return
     */
    public static int method1(int[] nums, int target){
        int l = 0;
        int r = nums.length;

        while(l <= r){
            int mid = (l + r)/2;
            if(target == nums[mid]){
                return mid;
            }else if(target >nums[mid]){
                l = mid +1;
            }else{
                r = mid - 1;
            }
        }
        return r;
    }
    /**
     * 插入的位置选择
     */
    public static int method2(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = (l + r)/2;
            if(l == r && target != nums[mid]){
                if (target < nums[mid]){
                    return mid;
                }else{
                    return mid + 1;
                }
            }
            if(r - l == 1){
                if(target == nums[l] || target < nums[l])return l;
                if(target == nums[r] || target < nums[r])return r;
                return r + 1;
            }
            if(target == nums[mid]){
                return mid;
            }else if(target >nums[mid]){
                l = mid +1;
            }else{
                r = mid - 1;
            }
        }
        return r;
    }
    public static int method3(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        while(l <= r){
            if (l == r){
                return target > nums[l] ? l + 1 : l - 1;
            }
            if (r - l == 1){
                if (target < nums[l]) return  l ;
                if (target > nums[r]) return r + 1;
                return r;
            }
            int mid = (l + r)/2;
            if (target > nums[mid]){
                l = mid + 1;
            }
            if (target < nums[mid]){
                r = mid - 1;
            }
        }
        return 0;
    }
    
}
