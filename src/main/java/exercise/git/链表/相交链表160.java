package exercise.git.链表;
/*
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
图示两个链表在节点 c1 开始相交：
题目保证不出现环
 */
//一次通过。
public class 相交链表160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA, tempB = headB;
        int lenA = 0, lenB = 0;
        while(tempA.next != null){
            tempA = tempA.next;
            lenA++;
        }
        while (tempB.next != null){
            tempB = tempB.next;
            lenB++;
        }
        if(tempA != tempB) return null;
        tempA = headA;
        tempB = headB;
        if (lenA > lenB){
            int len = lenA - lenB;
            while(len-- != 0)tempA = tempA.next;
        }
        if (lenA < lenB){
            int len = lenB - lenA;
            while(len-- != 0)tempB = tempB.next;
        }
        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}
