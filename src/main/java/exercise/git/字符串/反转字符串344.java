package exercise.git.字符串;

//反转有两种，一种是直接swap定义一个中间变量，另一种是用^=来进行    ^异或运算符，&同或
//任何数异或0，等于自身，任何数异或1，就取反。     一个数两次异或，等于自身
public class 反转字符串344 {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            s[l] ^= s[r];  //构造 a ^ b 的结果，并放在 a 中
            s[r] ^= s[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[l] ^= s[r];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            l++;
            r--;
        }
    }
}
