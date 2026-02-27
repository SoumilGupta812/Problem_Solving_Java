package Queue;
import java.util.*;
public class minDepth {
         class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int depth=0;
        while(!q.isEmpty()){
            depth++;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left == null && curr.right == null)
                    return depth;

                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
        }
        return depth;

    }
}
