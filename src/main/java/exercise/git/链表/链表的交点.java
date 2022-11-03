package exercise.git.链表;

import java.util.HashSet;
import java.util.Set;

public class 链表的交点 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        ListNode res1 = getPublicPoint1(l1, l2);
        ListNode res2 = getPublicPoint2(l1, l2);
    }
    //使用哈希表
    public static ListNode getPublicPoint1(ListNode headA, ListNode headB){
        Set<ListNode> list = new HashSet<>();
        while (headA != null) {
            list.add(headA);
            headA = headA.next;
        }
        while (headB != null && !list.contains(headB)) {
            headB = headB.next;
        }
        return headB;
    }
    //使用策略
    public static ListNode getPublicPoint2(ListNode headA, ListNode headB){
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != tempB){
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }
}
