package exercise.git.链表;

import java.util.ArrayDeque;
import java.util.Deque;

public class 链表求和 {
    public static void main(String[] args) {

    }
    //使用队列
    //这边要注意add poll是队列，push pop是栈
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        while(l1 != null){
            stack1.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.add(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.poll().val;
            int b = stack2.isEmpty() ? 0 : stack2.poll().val;
            int cur = a + b + carry;
            carry = cur / 10;
            cur = cur%10;
            ListNode curr = new ListNode(cur);
            temp.next = curr;
            temp = temp.next;
        }
        return res.next;
    }
}
