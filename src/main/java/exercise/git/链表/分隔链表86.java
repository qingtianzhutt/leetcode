package exercise.git.链表;
/*
给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
你应当 保留 两个分区中每个节点的初始相对位置。
 */
//直接通过。强势，中等题。
//链表题中  要明白指针。
public class 分隔链表86 {
    public ListNode partition(ListNode head, int x) {
        //这些small,big其实都是一个个指针，指向一个个内存地址。
        ListNode big = new ListNode(-1);
        ListNode small = new ListNode(-1);
        ListNode bigTemp = big, smallTemp = small, cur = head;
        while(cur != null){
            if (cur.val < x){
                smallTemp.next = cur;
                smallTemp = smallTemp.next;
            }else {
                bigTemp.next = cur;
                bigTemp = bigTemp.next;
            }
            cur = cur.next;
        }
        bigTemp.next = null;
        smallTemp.next = big.next;
        return small.next;
    }
}
