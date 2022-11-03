package exercise.git.链表;

public class 交换链表中的相邻节点 {
    public static void main(String[] args) {

    }

    public ListNode swapPairs1(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;

            pre = l1;
        }
        return node.next;
    }
    //递归
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //新的头结点是第二个节点
        ListNode newHead = head.next;
        //新链表中第二个节点连接后面的所有
        head.next = swapPairs2(newHead.next);
        //新头结点连接第二个节点
        newHead.next = head;
        //返回头结点
        return newHead;
    }
}
