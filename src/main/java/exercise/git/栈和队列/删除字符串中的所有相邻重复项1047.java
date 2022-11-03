package exercise.git.栈和队列;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

//注意pollFirst和pollLast的区别
public class 删除字符串中的所有相邻重复项1047 {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (Character single : s.toCharArray()){
            if (!stack.isEmpty() && single == stack.peek()){
                stack.pop();
                continue;
            }
            stack.push(single);
        }
        StringBuilder sb = new StringBuilder("");
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
    @Test
    public void test(){
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
}
