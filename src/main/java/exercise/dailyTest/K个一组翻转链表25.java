package exercise.dailyTest;

import exercise.git.链表.ListNode;
import org.junit.Test;

/*
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class K个一组翻转链表25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = head, end = dummy, pre = dummy;
        while(start != null){
            int n = k;
            while(n > 0){
                if (end == null) return dummy.next;
                end = end.next;
                n--;
            }
            ListNode next = end.next;
            reverse(pre, end);
            pre.next = end;
            start.next = next;
            pre = start;
            start = next;
        }
        return dummy.next;
    }
    private void reverse(ListNode pre, ListNode end){
        ListNode cur = pre.next;
        while(pre != end){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverseKGroup(node1, 2);
    }
}
