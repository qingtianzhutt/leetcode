package exercise.git.贪心算法;

import java.util.Arrays;

public class 分发饼干455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0, r = 0;
        int res = 0;
        while(l < g.length && r < s.length){
            if (s[r] >= g[l]) {
                res++;
                l++;
            }
            r++;
        }
        return res;
    }
}
