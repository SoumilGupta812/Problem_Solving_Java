public class add2numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        int carry = 0;
        while (list1 != null || list2 != null || carry != 0) {
            int sum = carry;
            if (list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }
            if (list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }
            carry = sum / 10;
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;
        }
        return ans.next;
    }
      static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
