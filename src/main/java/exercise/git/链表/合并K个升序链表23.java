package exercise.git.链表;

import java.util.PriorityQueue;

/*
给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class 合并K个升序链表23 {
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

    //优先队列的使用
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        //PriorityQueue<ListNode> pq2 = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
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
