import java.util.Scanner;

public class middleofLinkedList {
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

//        System.out.print("Original Linked List:");
//        listPrint(head);
//        ListNode middle=sortList(head);
//        listPrint(middle);
//        System.out.print("Original Linked List:");
//        listPrint(head);
        getMaximumGenerated(11);

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
    public static int getMaximumGenerated(int n) {
        int[] nums=new int[n+1];
        nums[0]=0;
        nums[1]=1;
        for(int i=0;i<=n;i++){
            if(!(2*i<=n)) break;
            nums[2 * i] = nums[i];
            if(!(2*i+1<=n)) break;
            nums[2 * i + 1] = nums[i] + nums[i + 1];
        }

        int max=0;
        for(int i=0;i<=n;i++){
            if(max<nums[i]) max=nums[i];
        }
        return max;

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
