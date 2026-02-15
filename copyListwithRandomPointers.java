import java.util.HashMap;

public class copyListwithRandomPointers {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap<>();
        Node curr=head;
        while(curr!= null)
        {
            map.put(curr,new Node(curr.val));
            curr=curr.next;
        }
        curr=head;
        Node ans=map.get(curr);

        while(curr!= null){
            Node copy=map.get(curr);
            copy.next=map.get(curr.next);
            copy.random=map.get(curr.random);
            curr=curr.next;
        }
        return ans;
    }
    public Node copyRandomList2(Node head) {
        Node curr=head;
        while(curr != null){
            Node copy=new Node(curr.val);
            copy.next=curr.next;
            curr.next=copy;
            curr=copy.next;
        }
        curr=head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }
        Node copyTail=new Node(0);
        Node tail=copyTail;
        curr=head;
        while(curr != null)
        {
            Node temp=curr.next;
            curr.next=temp.next;
            tail.next=temp;
            tail=temp;
            curr=curr.next;
        }
        return copyTail.next;

    }
}
