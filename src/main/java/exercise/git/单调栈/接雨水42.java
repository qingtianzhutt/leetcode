package exercise.git.单调栈;
//双指针，动态规划，单调栈。
public class 接雨水42 {
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            // 第一个柱子和最后一个柱子不接雨水
            if (i==0 || i== height.length - 1) continue;

            int rHeight = height[i]; // 记录右边柱子的最高高度
            int lHeight = height[i]; // 记录左边柱子的最高高度
            for (int r = i+1; r < height.length; r++) {
                if (height[r] > rHeight) rHeight = height[r];
            }
            for (int l = i-1; l >= 0; l--) {
                if(height[l] > lHeight) lHeight = height[l];
            }
            int h = Math.min(lHeight, rHeight) - height[i];
            if (h > 0) sum += h;
        }
        return sum;
    }

    //一次通过，牛逼，列法。
    public int trap2(int[] height) {
        int res = 0;
        int l = 0, r = 0;
        for (int i = 1; i < height.length - 1; i++){
             for (int m = i - 1; m >= 0; m--){
                 if (height[m] > height[i]){
                     l = Math.max(l, height[m]);
                 }
             }
             for (int n = i + 1; n < height.length; n++){
                 if (height[n] > height[i]){
                     r = Math.max(r, height[n]);
                 }
             }
             if (l != 0 && r != 0){
                 res += Math.min(l, r) - height[i];
             }
             //重置
             l = 0;
             r = 0;
        }
        return res;
    }
}
