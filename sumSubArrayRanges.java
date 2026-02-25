import java.util.ArrayDeque;

public class sumSubArrayRanges {    public long subArrayRanges(int[] nums) {
    return subArrayMax(nums)-subArrayMin(nums);
}
    public long subArrayMin(int[] nums){
        int n=nums.length;
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        int[] left=new int[n];
        int[] right=new int[n];
        long result=0;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&& nums[i]<nums[stack.peek()])
            {stack.pop();}
            left[i]=stack.isEmpty()?i+1:i-stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&& nums[i]<=nums[stack.peek()])
            {stack.pop();}
            right[i]=stack.isEmpty()?n-i:stack.peek()-i;
            stack.push(i);
        }

        for(int i=0;i<n;i++){
            result=result+(long)nums[i]*left[i]*right[i];
        }
        return result;
    }
    public long subArrayMax(int[] nums){
        int n=nums.length;
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        int[] left=new int[n];
        int[] right=new int[n];
        long result=0;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&& nums[i]>nums[stack.peek()])
                stack.pop();
            left[i]=stack.isEmpty()?i+1:i-stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&& nums[i]>=nums[stack.peek()])
                stack.pop();
            right[i]=stack.isEmpty()?n-i:stack.peek()-i;
            stack.push(i);
        }

        for(int i=0;i<n;i++){
            result=result+(long)nums[i]*left[i]*right[i];
        }
        return result;
    }
}
