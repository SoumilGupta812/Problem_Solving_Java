public class sortList {
    public static ListNode sortList(ListNode head) {
        if(head==null ||  head.next== null) return head;

        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=head;
        while(fast!=null && fast.next != null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(slow);

        return mergeList(left,right);
    }
    public static ListNode mergeList(ListNode left,ListNode right){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(left!=null && right != null){
            if(left.val<right.val){
                tail.next=left;
                left=left.next;
            }
            else{
                tail.next=right;
                right=right.next;
            }
            tail=tail.next;
        }
        if(left != null) tail.next=left;
        if(right != null) tail.next=right;
        return dummy.next;
    }
      static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
