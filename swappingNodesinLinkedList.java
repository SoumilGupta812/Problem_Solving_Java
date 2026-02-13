public class swappingNodesinLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        if ( head.next == null)
            return head;
        ListNode kthNodeStart = getKth(head, k);
        ListNode kthNodeEnd=lastKth(head,k);
        int temp=kthNodeStart.val;
        kthNodeStart.val=kthNodeEnd.val;
        kthNodeEnd.val=temp;
        return head;
    }

    public ListNode getKth(ListNode head, int k) {
        k--;
        ListNode curr = head;
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
    public ListNode lastKth(ListNode head,int k)
    {
        ListNode slow=head;
        ListNode fast =head;
        while(k>0){
            fast=fast.next;
            k--;
        }
        while(fast != null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
      static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
