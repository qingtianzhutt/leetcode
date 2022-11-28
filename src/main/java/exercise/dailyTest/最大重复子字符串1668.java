package exercise.dailyTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
 */
public class 最大重复子字符串1668 {
    public int maxRepeating(String sequence, String word) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sequence.length(); i++){
            int temp = i;
            for (int j = 0; j < word.length(); j++, temp++){
                if (temp == sequence.length() && sequence.charAt(temp) != word.charAt(j)){
                    break;
                }
            }
            if (temp == i + word.length()){
                list.add(i);
            }
        }
        int res = 1;
        int count = 1;
        if (list == null || list.size() == 0)return 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) == word.length()){
                count++;
                res = Math.max(res, count);
            }else {
                count = 1;
            }
        }
        return res;
    }
    //这里可能要学习下kmp算法了。
    public int maxRepeating2(String sequence, String word) {
        if (sequence == null || word == null)return 0;
        if (word.length() > sequence.length())return 0;
        int[] dp = new int[sequence.length()];
        dp[word.length() - 1] = sequence.substring(0, word.length()).equals(word) ? 1 : 0;
        int res = dp[word.length() - 1];
        for (int i = word.length(); i < sequence.length(); i++){
            if (sequence.substring(i - word.length() + 1, i + 1).equals(word)){
                dp[i] = dp[i - word.length()] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    @Test
    public void test(){
        String sequence = "baba";
        String word = "b";
        System.out.println(maxRepeating2(sequence, word));
    }
}
