package exercise.链表;

public class 分隔链表725 {


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}

          ListNode(int val) {
              this.val = val;
          }
          ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
      }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        if(head == null)return res;
        ListNode pre = head;
        int len = 1;
        while(pre.next != null){
            pre = pre.next;
        }
        int singleLen = len / k;
        int add = len % k;
        //循环k次
        ListNode cur = head;
        for(int i = 0; i < k; i++){
            int times = i < add ? singleLen : singleLen + 1;
            if(cur == null){
                res[i] = null;
            }
            while(head != null && times != 0){
                times--;
                head = head.next;
            }
            if(head == null){
                res[i] = cur;
                continue;
            }else {
                cur = head.next;
                head.next = null;
                res[i] = cur;
            }
        }
        return res;
    }
}
