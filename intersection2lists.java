public class intersection2lists {
     static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
          next = null;
      }
  }
    public ListNode getIntersectionNodeDifferent_way(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode tempA = headA;
        while (tempA != null) {
            tempA = tempA.next;
            lenA++;
        }
        int lenB = 0;
        ListNode tempB = headB;
        while (tempB != null) {
            tempB = tempB.next;
            lenB++;
        }
        tempA = headA;
        tempB = headB;
        if (lenA > lenB) {
            for (int i = 1; i <= lenA - lenB; i++) {
                tempA = tempA.next;
            }
        } else {
            for (int i = 1; i <= lenB - lenA; i++) {
                tempB = tempB.next;
            }
        }
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1=headA;
        ListNode p2=headB;
        while(p1!=p2){
            p1=(p1==null)?headB:p1.next;
            p2=(p2==null)?headA:p2.next;
        }
        return p1;
    }

}
