package leetcode._0021_Merge_Two_Sorted_Lists;

public class Merge_Two_Sorted_Lists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode mark = head;

        while(l1!=null && l2!=null) {
            if(l1.val <= l2.val){
                head.next = l1;
                l1 = l1.next;
            } else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        while (l1!=null){
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }

        while (l2!=null){
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        return mark.next;
    }
}
