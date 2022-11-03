package exercise.git.栈和队列;

import java.util.Deque;
import java.util.LinkedList;

public class 有效的括号20 {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return deque.isEmpty();
    }
    //一次通过，想法没问题
    public boolean isValid2(String s) {
        Deque<Character> stack  = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '}' && (stack.size() == 0 || stack.peek() != '{')) return false;
            if (cur == ']' && (stack.size() == 0 || stack.peek() != '[')) return false;
            if (cur == ')' && (stack.size() == 0 || stack.peek() != '(')) return false;
            if (cur == ')' || cur == ']' || cur == '}'){
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
}
