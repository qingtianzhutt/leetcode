package exercise.滑动窗口法;

/**
 * 给定一个字符串s，找出至多包含两个不同字符的最长子串t,并返回该子串的长度。
 */
public class 至多包含两个不同字符的最长子串 {
    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        int res = lengthOfLongestSubstringTwoDistinct(s);
        System.out.println(res);
    }
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        final int length = s.length();
        final int[] map = new int[128];
        int right = 0, left = 0;
        //count 为不同字符的数量
        for (int count = 0; right < length; ) {
            //右侧新字符进入窗口
            if (map[s.charAt(right++)]++ == 0) {
                count++;
            }
            //如果新字符进入窗口后使得 不同字符数量大于2，则左侧窗口也向右滑动一个（窗口平移）
            if (count > 2) {
                if (--map[s.charAt(left++)] == 0) {
                    count--;
                }
            }
        }
        return right - left;
    }
}
