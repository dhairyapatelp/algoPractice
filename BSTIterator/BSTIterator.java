/**
 * Using a Prioriy Queue
 * 
 */
import java.util.*;

class BSTIterator {
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
    PriorityQueue<Integer> pq;
    int size;
    public BSTIterator(TreeNode root) {
        pq = new PriorityQueue<>();
        helper(root, pq);
        
    }
    
    public void helper(TreeNode root, PriorityQueue<Integer> pq){
        if(root == null) return;
        pq.add(root.val);
        helper(root.left, pq);
        helper(root.right, pq);
    }
    
    /** @return the next smallest number */
    public int next() {
        return pq.poll();    
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return pq.size()>0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */