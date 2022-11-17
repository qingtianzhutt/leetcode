package exercise.git.链表;

import org.junit.Test;

/*
给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 */
//有环，返回第一个节点，无环，直接返回。
public class 环形链表二142 {
    public ListNode detectCycle(ListNode head) {
        if (judgeCircle(head)){
            //初始化的时候，不能让fast==low。
            ListNode fast = head.next.next, low = head.next;
            while(fast != low){
                fast = fast.next.next;
                low = low.next;
            }
            fast = head;
            while (fast != low){
                fast = fast.next;
                low = low.next;
            }
            return fast;
        }else {
            return null;
        }
    }
    private boolean judgeCircle(ListNode head){
        ListNode fast = head, low = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            low = low.next;
            if (fast == low){
                return true;
            }
        }
        return false;
    }
    @Test
    public void test(){
        ListNode root = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(detectCycle(root).val);
    }
}
