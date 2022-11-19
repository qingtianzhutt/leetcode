package exercise.dayTest;
/*
给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 */
public class 检查两个字符串数组是否相等1662 {
    //哈哈，一次通过，用的还是最方便的方法。
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null && word2 == null) {
            return true;
        }
        if (word1 == null || word2 == null) {
            return false;
        }
        int word1Index1 = 0, word1Index2 = 0;
        int word2Index1 = 0, word2Index2 = 0;
        while(word1Index1 < word1.length && word2Index1 < word2.length
                && word1Index2 < word1[word1Index1].length() && word2Index2 < word2[word2Index1].length()){
            if (word1[word1Index1].charAt(word1Index2) != word2[word2Index1].charAt(word2Index2)){
                return false;
            }
            if (word1Index2 == word1[word1Index1].length() - 1){
                word1Index2 = 0;
                word1Index1++;
            }else{
                word1Index2++;
            }
            if (word2Index2 == word2[word2Index1].length() - 1){
                word2Index2 = 0;
                word2Index1++;
            }else{
                word2Index2++;
            }
        }
        if (word1Index1 == word1.length && word2Index1 == word2.length){
            return true;
        }else{
            return false;
        }
    }
}
