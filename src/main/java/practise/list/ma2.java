package practise.list;

public class ma2 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,2};
        System.out.println(count(nums));
    }
    public static int count(int[] nums){
        if (nums == null || nums.length == 0)return 0;
        int res = 0;
        int[] dif = new int[nums.length];
        dif[0] = 1;
        for(int i = 1; i < nums.length; i++){
            dif[i] = nums[i] - nums[i - 1];
        }
        int[] val = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int base = 1;
            int pl = i + 1;
            while(pl < nums.length && dif[pl] < 0){
                base++;
                pl++;
            }
            if(i == 0){
                val[i] = Math.max(1, base);
            }else{
                if(dif[i] == 0){
                    val[i] = base;
                }else if(dif[i] > 0){
                    val[i] = Math.max(val[i - 1] + 1, base);
                }else if(dif[i] < 0){
                    val[i] = base;
                }
            }
        }
        for (int i : val){
            res += i;
        }
        return res;
    }
}
