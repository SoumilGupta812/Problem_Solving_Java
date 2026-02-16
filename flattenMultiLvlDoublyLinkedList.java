public class flattenMultiLvlDoublyLinkedList {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }
    public Node dfs(Node node){
        Node curr=node;
        Node last=null;
        while(curr != null)
        {
            Node next=curr.next;
            if(curr.child!= null){
                Node childTail=dfs(curr.child);
                Node childHead=curr.child;
                curr.next=childHead;
                childHead.prev=curr;
                curr.child=null;
                if(next!=null)
                {
                    childTail.next=next;
                    next.prev=childTail;
                }
                last=childTail;
                curr=childTail;

            }
            else{
                last=curr;
            }

            curr=curr.next;
        }
        return last;
    }
}
