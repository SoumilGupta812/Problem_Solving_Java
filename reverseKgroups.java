public class reverseKgroups {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null  || k==1) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prevGroup=dummy;
        while(true){
            ListNode kthNode=getKth(prevGroup,k);
            if(kthNode == null ) break;
            ListNode prev=kthNode.next;
            ListNode curr=prevGroup.next;
            ListNode nextGroup=prev;
            while(curr != nextGroup){
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }

            ListNode temp=prevGroup.next;
            prevGroup.next=prev;
            prevGroup=temp;
        }
        return dummy.next;
    }
    public static ListNode getKth(ListNode head,int k){
        ListNode curr=head;
        while(curr != null && k>0){
            curr=curr.next;
            k--;
        }
        return curr;
    }
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
