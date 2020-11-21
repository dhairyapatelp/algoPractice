/**
 * Using a Prioriy Queue
 * 
 */
import java.util.*;

class BSTIterator1 {
    public static void main(String[] args){
        
    }
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
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator1(TreeNode root) {
        stack = new Stack<>();
        helper(root);
    }
    
    public void helper(TreeNode root){
        if(root == null) return;
        stack.push(root);
        helper(root.left);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode ret = stack.pop();
        if(ret.right != null){
            helper(ret.right);
        }
        return ret.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();    
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */