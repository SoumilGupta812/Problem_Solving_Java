package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class queue {
    class MovingAverage {
        Queue<Integer> q;
        int size;
        double sum;

        public MovingAverage(int size) {
            q = new ArrayDeque<>();
            this.size = size;
            sum = 0;
        }

        public double next(int val) {
            sum += val;
            q.offer(val);
            while (q.size() > size) {
                sum -= q.poll();
            }
            return sum / q.size();
        }
    }
    class RecentCounter {
        private Queue<Integer> queue;
        public RecentCounter() {
            queue=new ArrayDeque<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while(t-3000>queue.peek())
            {
                queue.poll();
            }
            return queue.size();
        }
    }
    class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            stack1=new Stack<>();//for pushing
            stack2=new Stack<>();//for popping

        }

        public void push(int x) {
            stack1.push(x);

        }

        public int pop() {
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();

        }

        public boolean empty() {
            if(stack1.isEmpty() && stack2.isEmpty())
            {
                return true;
            }
            return false;

        }
    }

}
