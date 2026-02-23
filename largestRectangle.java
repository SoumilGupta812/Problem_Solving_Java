import java.util.ArrayDeque;
import java.util.Deque;

public class largestRectangle {
    public static int largestRectangleArea(int[] heights) {
        int maxArea=0;
        Deque<Integer> stack =new ArrayDeque<>();
        int n =heights.length;
        for (int i=0;i<=n;i++){
            int currentHeight=(i==n)?0:heights[i];
            while(!stack.isEmpty() && currentHeight<heights[stack.peek()])
            {
                int width;
                int height=heights[stack.pop()];
                if(stack.isEmpty()){
                    width=i;
                }
                else {
                    width=i-stack.peek();
                }
                maxArea=Math.max(maxArea,width*height);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2}));

    }
}
