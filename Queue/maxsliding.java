package Queue;

import java.util.ArrayDeque;

public class maxsliding {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] result=new int[n-k+1];
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        int index=0;
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && nums[i]>nums[dq.peekLast()]){
                dq.pollLast();
            }
            while(!dq.isEmpty() && dq.peek() <= i-k){
                dq.pollFirst();
            }
            dq.offer(i);
            if(i-k+1>=0)
                result[index++]=nums[dq.peekFirst()];
        }
        return result;
    }
}
