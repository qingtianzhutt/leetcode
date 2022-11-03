package exercise.git.字符串;

import org.junit.Test;

/*
给定一个字符串，逐个翻转字符串中的每个单词。

示例 1：
输入: "the sky is blue"
输出: "blue is sky the"

示例 2：
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

示例 3：
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class 反转字符串里的单词151 {
    public String reverseWords(String s) {
        //源字符数组
        char[] initialArr = s.toCharArray();
        //新字符数组
        char[] newArr = new char[initialArr.length+1];//下面循环添加"单词 "，最终末尾的空格不会返回
        int newArrPos = 0;
        //i来进行整体对源字符数组从后往前遍历
        int i = initialArr.length-1;
        while(i>=0){
            while(i>=0 && initialArr[i] == ' '){i--;}  //跳过空格
            //此时i位置是边界或!=空格，先记录当前索引，之后的while用来确定单词的首字母的位置
            int right = i;
            while(i>=0 && initialArr[i] != ' '){i--;}
            //指定区间单词取出(由于i为首字母的前一位，所以这里+1,)，取出的每组末尾都带有一个空格
            for (int j = i+1; j <= right; j++) {
                newArr[newArrPos++] = initialArr[j];
                if(j == right){
                    newArr[newArrPos++] = ' ';//空格
                }
            }
        }
        //若是原始字符串没有单词，直接返回空字符串；若是有单词，返回0-末尾空格索引前范围的字符数组(转成String返回)
        if(newArrPos == 0){
            return "";
        }else{
            return new String(newArr,0,newArrPos-1);
        }
    }

//    public String reverseWords(String s) {
//        //去除多余空格。
//        StringBuilder stringBuilder = deleteBlank(s);
//        //全部反转
//        reverse(stringBuilder);
//        //反转每个单词
//        String t = reverseSingleWord();
//        return t;
//
//    }
    private StringBuilder deleteBlank(String s){
        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        while(s.charAt(end) == ' ')end--;
        for (int i = 0; i <= end; i++) {
            //去掉重复的空格
            if (i > 0 && s.charAt(i) == ' ' && s.charAt(i - 1) == ' ')continue;
            sb.append(s.charAt(i));
        }
        return sb;
    }


    private void reverse(StringBuilder sb){
        int l = 0, r = sb.length() - 1;
        while(l < r){
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
            l++;
            r--;
        }
    }

    @Test
    public void test(){
        String s = "uuid\\ezztema4zgl6i8e89psn2k2ih9ik0k74";
        System.out.println(s);
        System.out.println(s.indexOf("uuid"));

    }
}
