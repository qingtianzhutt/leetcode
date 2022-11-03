package exercise.git.链表;

public class 从有序链表中删除重复节点 {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        while(temp != null && temp.next != null){
            while(temp.next != null && temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}
