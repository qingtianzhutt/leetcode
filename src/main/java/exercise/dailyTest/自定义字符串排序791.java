package exercise.dailyTest;

import org.junit.Test;

import java.util.*;

/*
给定两个字符串 order 和 s 。order 的所有字母都是 唯一 的，并且以前按照一些自定义的顺序排序。
对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
返回 满足这个性质的 s 的任意一种排列 。


 */
public class 自定义字符串排序791 {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < order.length(); i++) {
            list.add(order.charAt(i));
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (list.contains(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int n = map.get(list.get(i));
            while (n-- > 0) {
                sb.append(list.get(i));
            }
        }
        for (Character c : s.toCharArray()) {
            if (!list.contains(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s = "cba";
        String t = "abcd";
        System.out.println(customSortString(s, t));
    }

    //也算是一次通过了。
    public String customSortString2(String order, String s) {
        int[] nums = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            //这边char类型和字符串之间的转换。
            if (order.contains(String.valueOf(s.charAt(i)))) {
                nums[s.charAt(i) - 'a']++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        for (int i = 0; i < order.length(); i++) {
            int num = nums[order.charAt(i) - 'a'];
            while (num-- > 0) {
                sb.append(order.charAt(i));
            }
        }
        return sb.toString();
    }

    //这个方法也很好，将字符串转换为为字符数组进行处理。
    public String customSortString3(String order, String s) {
        int[] val = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            //这里为什么不使用hashmap来直接进行处理呢。
            val[order.charAt(i) - 'a'] = i + 1;
        }
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, (c0, c1) -> val[c0 - 'a'] - val[c1 - 'a']);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            ans.append(arr[i]);
        }
        return ans.toString();
    }

}
