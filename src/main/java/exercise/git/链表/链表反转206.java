package exercise.git.链表;
/*
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class 链表反转206 {
    //非递归版
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    //递归版
    public  ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        return null;
    }
    public  ListNode reverseList3(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur!= null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
