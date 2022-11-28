package exercise.dailyTest;

import exercise.git.链表.ListNode;

import java.util.*;

/*
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class 排序链表148 {
    //借助数据结构。
    public ListNode sortList(ListNode head) {
        if (head == null)return null;
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(list, (a, b) -> a - b);
        ListNode ret = new ListNode(list.get(0));
        cur = ret;
        for (int i = 1; i < list.size(); i++){
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return ret;
    }
    //不使用额外的空间
    public ListNode sortList2(ListNode head) {
        return null;
    }



}
