package exercise.git.链表;

import org.junit.Test;

public class test {
    @Test
    public void test(){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i <= 10; i++){
            ListNode temp = new ListNode(i);
            cur.next = temp;
            cur = cur.next;
        }
    }
}
