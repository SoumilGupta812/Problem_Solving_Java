import java.util.List;
import java.util.Scanner;
public class palindrome_linkedList {
    static public class ListNode {
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of nodes:");
        int n=sc.nextInt();
        ListNode head=new ListNode();
        ListNode temp=head;
        for (int i = 1; i <=n ; i++) {
            temp.val=sc.nextInt();
            if(i+1<=n)
                temp.next=new ListNode();
            temp=temp.next;
        }
        System.out.print("Original Linked List:");
        listPrint(head);
        System.out.println(isPalindrome(head));
        System.out.print("Original Linked List:");
        listPrint(head);
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null;
        while(slow!=null)
        {
            ListNode temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }
        ListNode first=head;
        ListNode second=prev;
        while(second!=null)
        {
            if(first.val!=second.val) return false;
            first=first.next;
            second=second.next;
        }
        return true;
    }

}
