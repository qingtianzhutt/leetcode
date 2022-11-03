package exercise.git.链表;

public class 删除链表倒数第n个节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        head.next = second;
        removeNthFromEnd(head, 2);
    }
    //找到删除节点的上一个节点，让删除节点的上一个节点指向删除节点的下一个节点。
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)return null;
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        if (n > len) return null;
        int num = len - n + 1;
        ListNode pre = new ListNode(0);
        pre.next = head;
        temp = pre;
        for (int i = 0; i < num - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return pre.next;


    }
}
