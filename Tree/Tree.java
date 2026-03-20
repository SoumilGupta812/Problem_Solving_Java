package Tree;
import java.util.*;
public class Tree {
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
    int max=-1001;

    public int maxPathSum(TreeNode root){
        maxPath(root);
        return max;
    }
    public int maxPath(TreeNode root)
    {
        if(root == null) return 0;
        int left=Math.max(0,maxPath(root.left));
        int right=Math.max(0,maxPath(root.right));
        max=Math.max(max,left+right+root.val);
        return root.val+Math.max(left,right);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ser = new StringBuilder();
        serializeHelper(root, ser);
        return ser.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder ser) {
        if (root == null) {
            ser.append("#,");
            return;
        }
        ser.append(root.val);
        ser.append(",");
        serializeHelper(root.left, ser);
        serializeHelper(root.right, ser);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] d = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(d));
        return deserializeHelper(data, q);
    }

    private TreeNode deserializeHelper(String data, Queue<String> q) {
        String curr = q.poll();
        if (curr.equals("#"))
            return null;
        TreeNode head = new TreeNode();
        head.val = Integer.parseInt(curr);
        head.left = deserializeHelper(data, q);
        head.right = deserializeHelper(data, q);
        return head;
    }
}
