package exercise.git.栈和队列;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class 逆波兰表达式求值150 {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            stack.push(count(stack, tokens[i]));
        }
        return Integer.parseInt(stack.pop());
    }
    private String count(Deque<String> stack, String symbol){
        int a, b;
        if (symbol.equals("+")){
            a = Integer.parseInt(stack.pop());
            b = Integer.parseInt(stack.pop());
            return String.valueOf(a + b);
        }else if (symbol.equals("-")){
            a = Integer.parseInt(stack.pop());
            b = Integer.parseInt(stack.pop());
            return String.valueOf(b - a);
        }else if (symbol.equals("*")){
            a = Integer.parseInt(stack.pop());
            b = Integer.parseInt(stack.pop());
            return String.valueOf(a * b);
        }else if (symbol.equals("/")){
            a = Integer.parseInt(stack.pop());
            b = Integer.parseInt(stack.pop());
            return String.valueOf(b / a);
        }
        return symbol;
    }
    //自己写的代码太冗余了，看了答案重新写一遍
    public int evalRPN2(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String s : tokens){
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }else if (s.equals("-")){
                stack.push(-stack.pop() + stack.pop());
            }else if (s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if (s.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    @Test
    public void test(){
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }
}
