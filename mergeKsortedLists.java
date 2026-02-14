import java.util.PriorityQueue;

public class mergeKsortedLists {
     static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length==0) return null;
        ListNode dummy=new ListNode(0);
        ListNode ans=dummy;

        PriorityQueue<ListNode> queue =new PriorityQueue<>((a, b)->a.val-b.val);

        for(ListNode list:lists){
            if(list!=null)
                queue.offer(list);
        }

        while(!queue.isEmpty()){
            ListNode minNode=queue.poll();
            dummy.next=minNode;
            dummy=dummy.next;
            if(minNode.next!= null)
                queue.offer(minNode.next);
        }
        return ans.next;

    }

    //Divide and Conquor
    public ListNode mergeKListsDivide(ListNode[] lists) {
        if(lists == null || lists.length==0) return null;
        return mergeList(lists,0,lists.length-1);
    }
    public ListNode mergeList(ListNode[] lists,int left ,int right)
    {
        if(left==right) return lists[left];
        int mid=left +(right-left)/2;
        ListNode first=mergeList(lists,left,mid);
        ListNode second=mergeList(lists,mid+1,right);
        return merge(first,second);
    }
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode(0);
        ListNode ans=dummy;
        while(list1 != null && list2!= null)
        {
            if(list1.val<list2.val){
                dummy.next=list1;
                list1=list1.next;
            }
            else{
                dummy.next=list2;
                list2=list2.next;
            }
            dummy=dummy.next;
        }
        if(list1!= null) dummy.next=list1;
        if(list2!= null) dummy.next=list2;
        return ans.next;
    }
}
