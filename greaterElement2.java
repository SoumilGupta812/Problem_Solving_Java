import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class greaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        Arrays.fill(result,-1);
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<2*n;i++){
            int current=nums[i%n];
            while(!stack.isEmpty() && current > nums[stack.peek()]){
                int index=stack.pop();
                result[index]=current;
            }
            if(i<n){
                stack.push(i);
            }
        }
        return result;
    }
}
