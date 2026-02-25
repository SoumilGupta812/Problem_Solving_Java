package Queue;

import java.util.ArrayDeque;

public class shortestSubArray {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        long[] prefix=new long[n+1];
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        for(int i=0;i<=n;i++){
            while(!dq.isEmpty() && prefix[i]-prefix[dq.peekFirst()]>=k){
                min=Math.min(min , i - dq.pollFirst());
            }
            while(!dq.isEmpty() && prefix[i]<=prefix[dq.peekLast()])
            {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return min==Integer.MAX_VALUE? -1 :min ;
    }}