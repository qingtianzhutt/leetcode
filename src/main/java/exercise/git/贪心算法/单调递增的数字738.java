package exercise.git.贪心算法;

import org.junit.Test;
/*
给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
输入: N = 10
输出: 9
输入: N = 1234
输出: 1234
输入: N = 332
输出: 299
说明: N 是在 [0, 10^9] 范围内的一个整数。
 */
public class 单调递增的数字738 {
    public int monotoneIncreasingDigits(int N) {
        String[] strings = (N + "").split("");
        int start = strings.length;
        for (int i = strings.length - 1; i > 0; i--) {
            if (Integer.parseInt(strings[i]) < Integer.parseInt(strings[i - 1])) {
                strings[i - 1] = (Integer.parseInt(strings[i - 1]) - 1) + "";
                start = i;
            }
        }
        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }
        return Integer.parseInt(String.join("",strings));
    }
    //存在的问题，character字符型没办法直接转换为整数型 可以通过s - '0'来进行转换。char类型数据可以直接来进行大小对比。
    public int monotoneIncreasingDigits2(int N) {
        String s = String.valueOf(N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (judgeRise(s, i)){
                sb.append(s.charAt(i));
            }else{
                sb.append(s.charAt(i) - '0' - 1);
                while(++i < s.length()){
                    sb.append(9);
                }
                break;
            }
        }
        return Integer.parseInt(sb.toString());

    }
    private boolean judgeRise(String s, int index){
        boolean res = false;
        while(index < s.length() - 1){
            if (s.charAt(index) == s.charAt(index + 1)) {
                index++;
            }else {
                return s.charAt(index) <  s.charAt(index + 1);
            }

        }
        return true;
    }

    @Test
    public void test(){
        int s = 133452;
        System.out.println(monotoneIncreasingDigits5(s));
    }


    public int monotoneIncreasingDigits5(int N) {
        String s = String.valueOf(N);
        StringBuilder sb = new StringBuilder();
        int sameCount = 0;
        boolean isIncrease = true;
        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i + 1) > s.charAt(i)){
                if (sameCount != 0){
                    while(sameCount != 0){
                        sameCount--;
                        sb.append(s.charAt(i));
                    }
                }
                sb.append(s.charAt(i));
            }else if(s.charAt(i + 1) == s.charAt(i)){
                sameCount++;
            }else{
                sb.append(s.charAt(i) - '1');
                isIncrease = false;
                break;
            }
        }
        if (isIncrease){
            sb.append(s.charAt(s.length() - 1));
        }else {
            fillRes(sb, s);
        }
        return Integer.parseInt(sb.toString());
    }
    private void fillRes(StringBuilder sb, String s){
        int num = s.length() - sb.length();
        while(num-- != 0){
            sb.append('9');
        }
    }

}
