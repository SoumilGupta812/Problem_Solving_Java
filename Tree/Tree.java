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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q=new ArrayDeque<>();
        List<Double> ans=new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            long sum=0;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                sum+=curr.val;
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
            }
            double avg=(double)sum/size;
            ans.add(avg);
        }
        return ans;
    }
    public static List<String> res;
    public static List<String> binaryTreePaths(TreeNode root) {
        if(root==null) return null;
        res=new ArrayList<>();
        helper(root,new ArrayList<>());
        return res;
    }
    public static void helper(TreeNode root,List<Integer> list){
        if(root==null) return;
        if(root.left==null && root.right==null){
            list.add(root.val);
            addStr(list);
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
        list.remove(list.size()-1);
    }
    public static void addStr(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
            if(i!=list.size()-1) sb.append("->");
        }
        res.add(new String(sb));
    }
}
