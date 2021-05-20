package leetcode._0002_Add_Two_Numbers;



public class Add_Two_Numbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre = 0;
        boolean flag = true;
        ListNode head = null;
        ListNode preNode = new ListNode();
        while(l1 != null && l2 != null){
            int v1 = l1.val;
            int v2 = l2.val;
            int sum = v1+v2+pre;
            int next = sum%10;
            pre = sum/10;

            ListNode l = new ListNode(next);
            if(flag){
                head = l;
                flag = false;
            }
            preNode.next = l;
            preNode = preNode.next;
            l1 = l1.next;
            l2 = l2.next;

        }
        while(l1!=null){
            int v1 = l1.val;
            int sum = v1+pre;
            int next = sum%10;
            pre = sum/10;

            ListNode l = new ListNode(next);

            preNode.next = l;
            preNode = preNode.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int v2 = l2.val;
            int sum = v2+pre;
            int next = sum%10;
            pre = sum/10;

            ListNode l = new ListNode(next);

            preNode.next = l;
            preNode = preNode.next;
            l2 = l2.next;
        }
        if(pre>0){
            preNode.next = new ListNode(pre);
        }
        return head;
    }
    //考虑进位
    //考虑头结点的保存
    //考虑有一条链表已经没了剩下一部分还要继续算
    //考虑最后可能会有一个1进位留下所以需要生产新的结点
}
