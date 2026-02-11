import java.util.Scanner;

public class cycleDetection {
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

        System.out.println((hasCycle(head)));
        System.out.print("Original Linked List:");
        listPrint(head);
    }
    public static boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;

    }

    // Linked List Cycle II 142
//Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
// Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle.
// Note that pos is not passed as a parameter.
//Do not modify the linked list.
    public static ListNode hasCycle2(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                ListNode newPointer=head;
                {
                    while(slow!=newPointer){
                        slow=slow.next;
                        newPointer=newPointer.next;
                    }
                    return newPointer;

                }
            }
        }
        return null;
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
