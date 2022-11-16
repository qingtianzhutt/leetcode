package exercise.git.链表;

import exercise.git.双指针.最长子序列;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
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
    //也算是一次通过了，牛逼啊
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(!isAllEmpty(lists)){
            cur.next = smallestNode(lists);
            cur = cur.next;
        }
        return head.next;
    }
    private boolean isAllEmpty(ListNode[] list){
        for (ListNode node : list){
            if (node != null) return false;
        }
        return true;
    }
    private ListNode smallestNode(ListNode[] list){
        int index = 0 ;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < list.length; i++){
            if (list[i] != null && list[i].val < count){
                count = list[i].val;
                index = i;
            }
        }
        //这边有点迷。
        ListNode res = list[index];
        list[index] = list[index].next;
        return res;
    }

    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        ListNode[] list = new ListNode[2];
        list[0] = node1;
        list[1] = node4;
        System.out.println(mergeKLists(list));
    }
    //使用优先队列来进行解决,这种方法是比较好的，而且很简单。
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        //PriorityQueue<ListNode> pq1 = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });
        for (ListNode node : lists){
            if (node != null){
                pq.offer(node);
            }
        }
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            cur.next = temp;
            cur = cur.next;
            if (temp.next != null){
                pq.offer(temp.next);
            }
        }
        return head.next;
    }


}
