package exercise.git.链表;

public class 链表元素按奇偶数聚集 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        oddEvenList(l1);

    }
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(1);
        ListNode oddTemp = oddHead, evenTemp = evenHead;
        int i = 1;
        while(head != null){
            if (i%2 == 1) {
                oddTemp.next = head;
                oddTemp  = oddTemp.next;
            }else{
                evenTemp.next = head;
                evenTemp = evenTemp.next;
            }
            head = head.next;
            i++;
        }
        evenTemp.next = null;
        oddTemp.next = evenHead != null ? evenHead.next : null;
        return oddHead.next;
    }
}
