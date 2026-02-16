import java.util.HashMap;


public class lruCache{
    static class LRUCache {
        class Node{
            int key,val;
            Node next;
            Node prev;
            Node(int key,int val){
                this.key=key;
                this.val=val;
            }
        }
        private Node head;
        private Node tail;
        private int capacity;
        private HashMap<Integer,Node> map;


        public LRUCache(int capacity) {
            this.capacity=capacity;
            map=new HashMap<>();
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
        }

        public int get(int key) {
            if(!map.containsKey(key)){
                return -1;
            }
            Node node=map.get(key);
            remove(node);
            insert(node);
            return node.val;

        }
        public void put(int key, int value) {
            if(map.containsKey(key)){
                remove(map.get(key));
            }
            Node node=new Node(key,value);
            map.put(key,node);
            remove(node);
            insert(node);
            if(map.size()>capacity)
            {
                Node lru=tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
        }
        public void remove(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
        public void insert(Node node){
            node.next=head.next;
            node.prev=head;
            head.next.prev=node;
            head.next=node;
        }
    }
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        obj.put(4,4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}