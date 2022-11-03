package exercise.git.链表;

public class 分隔链表 {
    public static void main(String[] args) {

    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        int left = len%k;
        int size = len/k;
        temp = head;
        for(int i = 0; i < k; i++){
            if (temp == null){
                res[i] = null;
                continue;
            }
            res[i] = temp;
            int sizeSingle = i < left ? size + 1 : size;
            while(sizeSingle > 1){
                sizeSingle--;
                temp = temp.next;
            }
            ListNode next = temp.next;
            temp.next = null;
            temp = next;
        }
        return res;
    }
}
