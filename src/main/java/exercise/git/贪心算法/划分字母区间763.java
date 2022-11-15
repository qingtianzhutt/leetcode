package exercise.git.贪心算法;

import org.junit.Test;

import java.util.*;
/*
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8] 解释： 划分结果为 "ababcbaca", "defegde", "hijhklij"。 每个字母最多出现在一个片段中。 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
S的长度在[1, 500]之间。
S只包含小写字母 'a' 到 'z' 。
 */
public class 划分字母区间763 {
    //参考正确的方法
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx,edge[chars[i] - 'a']);
            if (i == idx) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }
    //我自己的写法错了，得不到正确答案。
    public List<Integer> partitionLabels2(String S) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map[chars[i] - 'a'] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i] - 'a'] != i) {
                int end = 0;
                for (int j = i; j < map[chars[i] - 'a']; j++){
                    end = Math.max(end, map[chars[j] - 'a']);
                }
                res.add(end - i + 1);
                i = end;
            }else {
                res.add(1);
            }
        }
        return res;
    }

    @Test
    public void test(){
        String s = "qiejxqfnqceocmy";
        partitionLabels2(s);
    }
    //都是一次通过，真是牛啊
    public List<Integer> partitionLabels3(String S) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        //找到S中每个元素的下标
        for (int i = 0; i < S.length(); i++){
            map.put(S.charAt(i), i);
        }
        int start = 0;
        int end;
        while(start < S.length()){
            end = map.get(S.charAt(start));
            for (int i = start; i <= end; i++){
                end = Math.max(end, map.get(S.charAt(i)));
            }
            res.add(end - start + 1);
            start = end + 1;
        }
        return res;
    }

}
