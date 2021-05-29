package leetcode._0019_Remove_Nth_Node_From_End_of_List;

public class Remove_Nth_Node_From_End_of_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=null,second=head,pre=null;
        int count = 1;
        boolean flag = true;

        while (second!=null){
            if(count != n){
                count++;
            } else{
                if(flag){
                    pre = null;
                    first = head;
                    flag = false;
                } else{
                    pre = first;
                    first = first.next;
                }

            }
            second = second.next;
        }
        if(pre != null)
            pre.next = first.next;
        else if(first == null)
            return null;
        else
            head = head.next;
        return head;
    }
    //快慢指针、栈
}
