/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class isValidBST{
    public static class TreeNode {
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

    public static void main(String[] args){
        isValidBST obj = new isValidBST();
        TreeNode node1 = new TreeNode(-2, null, null);
        TreeNode node2 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(8, null, null);
        TreeNode node4 = new TreeNode(12, null, null);
        TreeNode node5 = new TreeNode(1, node1, node2);
        TreeNode node6 = new TreeNode(10, node3, node4);
        TreeNode node = new TreeNode(5, node5, node6);

        System.out.println(obj.checkIfValidBST(node));
    }


    public boolean checkIfValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    public boolean helper(TreeNode node, TreeNode min, TreeNode max){
        if(node == null) return true;
        if(min != null && node.val<=min.val) return false;
        if(max != null && node.val>=max.val) return false;
        boolean left = helper(node.left, min, node);
        boolean right = helper(node.right, node, max);

        return left&&right;
    }
}