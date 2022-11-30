package exercise.dailyTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */

public class 单词拆分139 {
    //一言不合就想用回溯,超出时间限制了，日。但是代码似乎没问题，跑过了部分用例。35 / 45 个测试用例。
    public boolean wordBreak(String s, List<String> wordDict) {
        List<String> smallDict = new ArrayList<>();
//        for (String s1 : wordDict) {
//            if (s.contains(s1)){
//                smallDict.add(s1);
//            }
//        }
//        return dfs(s, smallDict, 0);
        return dfs(s, wordDict, 0);
    }
    private boolean dfs(String s, List<String> wordList, int index){
        if (index >= s.length()){
            return true;
        }
        for (int i = 0; i < wordList.size(); i++){
            if (s.length() - index >= wordList.get(i).length() && s.startsWith(wordList.get(i), index)){
                if (dfs(s, wordList, index + wordList.get(i).length())){
                    return true;
                }
            }
        }
        return false;
    }
    //动态规划,也算是直接通过了。
    /*
    知识点：s.startsWith的用法。
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < wordDict.size(); j++){
                if (i - wordDict.get(j).length() == -1 && s.startsWith(wordDict.get(j), i - wordDict.get(j).length() + 1)){
                    dp[i] = true;
                }else if (i - wordDict.get(j).length() >= 0 && s.startsWith(wordDict.get(j), i - wordDict.get(j).length() + 1) && dp[i - wordDict.get(j).length()]){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length() - 1];
    }

    @Test
    public void test(){
    }
}
