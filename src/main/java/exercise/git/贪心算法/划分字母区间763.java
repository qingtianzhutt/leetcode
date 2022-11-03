package exercise.git.贪心算法;

import org.junit.Test;

import java.util.*;

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

}
