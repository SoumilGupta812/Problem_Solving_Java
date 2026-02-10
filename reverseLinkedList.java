public class reverseLinkedList {
    public static ListNode reverse(ListNode head){
        if (head==null ) return head;
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null)
        {
            ListNode nextNode=temp.next;
            ListNode newNode=new ListNode(temp.val);
            newNode.next=prev;
            prev=newNode;
            temp=nextNode;

        }
        return prev;
    }
    public static void listPrint(ListNode head){
        ListNode temp=head;
        System.out.print("[");
        while(temp!=null)
        {
            System.out.print(temp.val+" ");
            if (temp.next!=null) System.out.print(",");
            temp=temp.next;
        }
        System.out.print("]");
        System.out.println();
    }
    public static void reverseRecursion(ListNode reverse, ListNode head) {
        if (head == null) {
            listPrint(reverse);
            return;
        }
        ListNode temp = head;
        ListNode newNode = new ListNode(temp.val);
        newNode.next = reverse;
        reverse = newNode;
        reverseRecursion(reverse, temp.next);
    }
    public static ListNode reverseRecursion2(.ListNode reverse, .ListNode head) {
        if (head == null) {

            return reverse;
        }
        ListNode temp = head;
        ListNode newNode = new ListNode(temp.val);
        newNode.next = reverse;
        reverse = newNode;
        return reverseRecursion2(reverse, temp.next);
    }
    public static ListNode reverseRecursion3(.ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        ListNode current = new ListNode(temp.val);
        ListNode reverse = reverseRecursion3(temp.next);
        if (reverse != null) {
            ListNode temp2=reverse;
            while (temp2.next != null) {
                temp2=temp2.next ;
            }
            temp2.next=current;
            current = reverse;
        }
        return current;
    }

    //Understand it after backtracking....
//    public static ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode newHead = reverseList(head.next);
//
//        head.next.next = head; // reverse link
//        head.next = null;      // break old link
//
//        return newHead;
//    }
    static class ListNode {
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
}
