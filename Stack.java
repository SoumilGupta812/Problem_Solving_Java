import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Stack {
    public boolean isValid(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        for(char c:s.toCharArray())
        {
            if(c=='('){
                stack.push(')');
            }
            else if(c=='{'){
                stack.push('}');
            }
            else if(c=='[')
            {
                stack.push(']');
            }
            else{
                if(stack.isEmpty() || c!=stack.pop())
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack=new ArrayDeque<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums2){
            while(!stack.isEmpty() && n>stack.peek()){
                map.put(stack.pop(),n);
            }
            stack.push(n);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        int[] result=new int[nums1.length];
        for (int i=0;i<nums1.length;i++){
            result[i]=map.get(nums1[i]);
        }
        return result;
    }

}
