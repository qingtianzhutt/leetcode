//package exercise.git.链表;
///*
//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
// */
//public class K个一组翻转链表25 {
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode cur = dummy;
//        ListNode nextTop = dummy.next;
//        while(cur != null){
//            int n = k;
//            ListNode pre = cur;
//            while(n > 0){
//                if (cur == null)return dummy.next;
//                cur = cur.next;
//            }
//            reverse(pre, cur);
//        }
//    }
//    private void reverse(ListNode pre, ListNode end){
//        ListNode cur = pre.next;
//        ListNode
//    }
//}
