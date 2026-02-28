package Queue;

public class designCircularQueue {
    class MyCircularQueue {
        private int[] array;
        private int rear;
        private int front;
        private int size;
        private int k;

        public MyCircularQueue(int k) {
            array=new int[k];
            rear=-1;
            front=0;
            size=0;
            this.k=k;

        }

        public boolean enQueue(int value) {
            if(!isFull()){
                rear=(rear+1)%k;
                array[rear]=value;
                size++;
                return true;
            }
            return false;
        }

        public boolean deQueue() {
            if(!isEmpty()){
                front=(front+1)%k;
                size--;
                return true;}
            return false;
        }

        public int Front() {
            if(isEmpty())
                return -1;
            return array[front];
        }

        public int Rear() {
            if(isEmpty())
                return -1;
            return array[rear];
        }

        public boolean isEmpty() {
            return size==0;

        }

        public boolean isFull() {
            return size==k;

        }
    }
}
