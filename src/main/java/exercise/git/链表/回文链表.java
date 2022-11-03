package exercise.git.链表;

import java.util.ArrayDeque;
import java.util.Deque;

public class 回文链表 {
    public static void main(String[] args) {

    }
    //使用栈
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode temp = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while(head != null){
            if (stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    //不使用栈
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode temp = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while(head != null){
            if (stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

}
