package exercise.git.字符串;

import org.junit.Test;
/*
给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。

如果剩余字符少于 k 个，则将剩余字符全部反转。

如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

示例:

输入: s = "abcdefg", k = 2
输出: "bacdfeg"
 */
public class 反转字符串二541 {
    public String reverseStr(String s, int k) {
        StringBuffer res = new StringBuffer();
        int length = s.length();
        int start = 0;
        while (start < length) {
            // 找到k处和2k处
            StringBuffer temp = new StringBuffer();
            // 与length进行判断，如果大于length了，那就将其置为length
            int firstK = (start + k > length) ? length : start + k;
            int secondK = (start + (2 * k) > length) ? length : start + (2 * k);

            //无论start所处位置，至少会反转一次
            temp.append(s.substring(start, firstK));
            res.append(temp.reverse());

            // 如果firstK到secondK之间有元素，这些元素直接放入res里即可。
            if (firstK < secondK) { //此时剩余长度一定大于k。
                res.append(s.substring(firstK, secondK));
            }
            start += (2 * k);
        }
        return res.toString();
    }
    //自己写的太垃圾了了，还是用别人的吧。
    public String reverseStr2(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i += 2 * k){
            int start = i;
            //这里是判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1, start + k - 1);
            //用异或运算反转
            while(start < end){
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }
    @Test
    public void test(){
        String s = "qintaozhiqintaozhi";
        int k = 3;
        System.out.println(reverseStr4(s, k));
    }
    //也是一次通过美滋滋
    //以2K为循环来进行遍历。
    public String reverseStr3(String s, int k) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i += 2 * k) {
            int end = i + k > str.length ? str.length - 1 : i + k - 1;
            swap(str, i, end);
        }
        return new String(str);
    }
    public void swap(char[] str, int start, int end){
        while(start < end){
            char s = str[start];
            str[start] = str[end];
            str[end] = s;
            start++;
            end--;
        }
    }


    public String reverseStr4(String s, int k) {
        char[] chars = s.toCharArray();
        int count = 0;
        int l = 0;
        for (int i = 0; i < chars.length; i++){
            count++;
            if (count == k){
                swap(chars, l, i);
                l = i + k + 1;
                continue;
            }else if (count == 2 * k){
                count = 0;
                continue;
            }
            if (i == chars.length - 1 && count < k){
                swap(chars, l, i);
            }
        }
        return new String(chars);
    }


}
