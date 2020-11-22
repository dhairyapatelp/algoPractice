
class SumRootToLeaf {
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
    int ans;
    public static void main(String[] args){

    }

    public int sumNumbers(TreeNode root) {
        ans = 0;
        helper(root, 0);
        
        return ans;
    }
    
    public void helper(TreeNode root, int num){
        if(root == null) return;
        num *= 10;
        num += root.val;
        if(root.left == null && root.right == null) {
            ans+=num;
            return;
        }
        helper(root.left, num);
        helper(root.right, num);
    }
}