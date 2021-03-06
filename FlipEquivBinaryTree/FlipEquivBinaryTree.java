import java.util.Stack;

class FlipEquivBinaryTree {
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
    
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        
        s1.push(root1);
        s2.push(root2);
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            TreeNode n1 = s1.pop();
            TreeNode n2 = s2.pop();
            
            if(n1 == null && n2 != null) return false;
            if(n1 != null && n2 == null) return false;
            
            
            if(n1 != null && n2 != null){
                if(n1.val != n2.val) return false;
            if(n1.left == n2.left || n1.left != null && n2.left != null && n1.left.val == n2.left.val){
                s1.push(n1.left);
                s1.push(n1.right);
            } else{
                s1.push(n1.right);
                s1.push(n1.left);
            }
            
            s2.push(n2.left);
            s2.push(n2.right);    
            }
            
        }
        
        return s1.isEmpty() == s2.isEmpty();
    }
}