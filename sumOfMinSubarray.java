import java.util.ArrayDeque;

public class sumOfMinSubarray {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long result=0;
        int mod=1_000_000_007;
        int[] left =new int[n];
        int[] right =new int[n];
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for (int i=0;i<n;i++){
            while(!stack.isEmpty()&& arr[i]< arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty())
                left[i]=i+1;
            else
                left[i]=i-stack.peek();
            stack.push(i);
        }
        stack.clear();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty())
                right[i]=n-i;
            else
                right[i]=stack.peek()-i;
            stack.push(i);
        }

        for(int i=0;i<n;i++){
            result=(result +(long)arr[i]*left[i]*right[i])%mod;
        }
        return (int)result;
    }
}
