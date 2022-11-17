package exercise.git.链表;
/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
//一次通过，找到倒数第k个节点的上一个节点，然后cur.next = cur.next.next;
//注意：记住头结点的上一个节点，因为头结点可能被删除。
public class 删除链表的倒数第N个结点19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //找到倒数第n + 1个节点。
        if (head == null)return null;
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        if (n > len)return null;
        temp = new ListNode(0);
        temp.next = head;
        ListNode cur = temp;
        int k = len - n;
        while(k != 0){
            k--;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return temp.next;
    }
}
