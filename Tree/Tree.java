package Tree;

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
}
