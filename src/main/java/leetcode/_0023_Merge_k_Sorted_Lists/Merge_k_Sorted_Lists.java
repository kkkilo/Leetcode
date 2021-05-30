package leetcode._0023_Merge_k_Sorted_Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Merge_k_Sorted_Lists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }

        int len = lists.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ListNode cur = lists[i];
            while (cur!=null){
                arr.add(cur.val);
                cur = cur.next;
            }
        }
        Collections.sort(arr);

        ListNode head = new ListNode();
        ListNode cur = head;
        if(arr.size() == 0){
            return null;
        }
        int arrLen = arr.size();
        for (int i = 0; i < arrLen; i++) {
            cur.next = new ListNode(arr.get(i));
            cur = cur.next;
        }
        return head.next;
    }
}
