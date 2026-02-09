import java.util.Scanner;

public class middleofLinkedList {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of nodes:");
        int n=sc.nextInt();
        ListNode head=new ListNode();
        ListNode temp=head;

        for (int i = 1; i <=n ; i++) {
            temp.val=sc.nextInt();
            if(i+1<=n)
            temp.next=new ListNode();
            temp=temp.next;
        }
        listPrint(head);
        ListNode middle=middleNode(head);
        listPrint(middle);

    }
    public static void listPrint(ListNode head){
        ListNode temp=head;
        while(temp!=null)
        {
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
    public static ListNode middleNode(ListNode head) {
        if(head.next==null) return head;
        if(head.next.next==null) return head.next;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;


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
