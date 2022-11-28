package exercise.git.链表;
/*
给定一个头结点为 head 的非空单链表，返回链表的中间结点。
如果有两个中间结点，则返回第二个中间结点。
 */
//最通俗的想法就是求出链表长度，然后走一半。但是这样要遍历两次链表。使用快慢指针的方式可以只走一次。
//1分钟写完。
public class 链表的中间结点876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode right = head, left = head;
        while(right != null && right.next != null){
            right = right.next.next;
            left = left.next;
        }
        return left;
    }
}
