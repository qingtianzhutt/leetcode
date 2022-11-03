package exercise.git.链表;

public class 链表反转 {
    public static void main(String[] args) {
        ListNode l = new ListNode(3);
        ListNode res = reverseList1(l);
    }
    //非递归版
    public static ListNode reverseList1(ListNode head) {
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
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        return null;

    }
}
