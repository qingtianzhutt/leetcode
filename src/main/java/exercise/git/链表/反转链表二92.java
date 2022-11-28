package exercise.git.链表;

import org.junit.Test;

/*
给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回反转后的链表 。
 */
//想法就是保存几个节点，直接在原链表上硬反转。
//看错题目了，是反转从left到right的节点，而不是交换left和right的节点。
public class 反转链表二92 {

    //这个是交换left和right的节点，一次通过，但是题目理解错了。
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        int index = 0;
        ListNode lpre = null, rpre = null;
        while(temp != null){
            if (index == left - 1){
                lpre = temp;
            }else if (index == right - 1){
                rpre = temp;
            }
            temp = temp.next;
            index++;
        }
        ListNode lcur = lpre.next;
        ListNode rcur = rpre.next;
        ListNode lnext = lcur.next;
        ListNode rnext = rcur.next;
        if (right - left == 1){
            lnext = lcur;
            rpre = rcur;
        }
        lpre.next = rcur;
        rcur.next = lnext;
        rpre.next = lcur;
        lcur.next = rnext;
        return dummy.next;
    }
    //和反转整个链表区别不大。也算一次通过。
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (head == null || left == right)return head;
        ListNode lpre = null, rnext = null, lcur = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        int index = 0;
        while(temp != null){
            if (index == left - 1){
                lpre = temp;
            }else if (index == left){
                lcur = temp;
            }else if (index == right + 1){
                rnext = temp;
            }
            temp = temp.next;
            index++;
        }
        ListNode pre = rnext;
        while(lcur != rnext){
            temp = lcur.next;
            lcur.next = pre;
            pre = lcur;
            lcur = temp;
        }
        lpre.next = pre;
        return dummy.next;
    }
    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = reverseBetween2(node1, 1, 4);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
