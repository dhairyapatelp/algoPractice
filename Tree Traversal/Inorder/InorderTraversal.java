import java.util.*;

class InorderTraversal{
	static class TreeNode{
		int val;
	    TreeNode left;
	    TreeNode right;

	    TreeNode() {}
	    TreeNode(int val) { 
	    	this.val = val; 
	    }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}

	public static void main(String[] args){
		InorderTraversal obj = new InorderTraversal();
		TreeNode node = new TreeNode();
		node.val = 4;

		TreeNode left = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null));
		TreeNode right = new TreeNode(6, new TreeNode(5, null, null), new TreeNode(7, null, null));

		node.left = left;
		node.right = right;

		List<Integer> list = new ArrayList<Integer>();
		obj.inorder(node, list);
		for(Integer each: list) System.out.println(each);
	}

	public void inorder(TreeNode root, List<Integer> list){
		if(root == null) return;
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);

		return;
	}
}