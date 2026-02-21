import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class stockSpan {
    private Deque<Integer> stack;
    private ArrayList<Integer> array;
    private int index;
    public stockSpan() {
        stack=new ArrayDeque<>();
        array=new ArrayList<>();
        index=0;
    }

    public int next(int price) {
        array.add(price);
        while(!stack.isEmpty() && price>=array.get(stack.peek())){
            stack.pop();
        }
        int result;
        if(stack.isEmpty())
            result=index+1;
        else result=index-stack.peek();
        stack.push(index);index++;
        return result;
    }
}
