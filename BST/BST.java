import java.util.*;

public class BST{

	public static void main(String[] args){
		TreeNode node = new TreeNode(50);
		TreeNode dummy = node;
		List<Integer> list = new ArrayList<Integer>();
		BST root = new BST();
        root.insert(dummy, 30); 
        root.insert(dummy, 20);
        root.insert(dummy, 40); 
        root.insert(dummy, 70); 
        root.insert(dummy, 60); 
        root.insert(dummy, 80);
        root.insert(dummy, 1);
  		
        // print inorder traversal of the BST 
        dummy = node;

        root.inorder(dummy, list);
        for(Integer each: list) System.out.println("Node: "+each);

        System.out.println("Searching for Node 111:" +root.search(node, 111));
    	System.out.println("Deleting node 70:" +root.delete(node, 70));
    	list.clear();
    	root.inorder(dummy, list);
    	for(Integer each: list) System.out.println("Node: "+each);
	}

	private TreeNode inorder(TreeNode root, List<Integer> list){
		if(root == null) {
			return null;	
		}
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);

		return root;
	}

	private TreeNode insert(TreeNode root, int newNode){
		if(root == null) return new TreeNode(newNode);
		if(root.val < newNode){
			root.right = insert(root.right, newNode);
		}
		if(root.val > newNode){
			root.left = insert(root.left, newNode);
		}
		return root;
	}

	private boolean search(TreeNode root, int newNode){
		boolean left = false; 
		boolean right = false;

		if(root == null) return false;
		if(root.val == newNode){
			return true;	
		} 
		if(root.val < newNode){
			right = search(root.right, newNode);
		} 
		if(root.val > newNode){
			left = search(root.left, newNode);	
		} 

		return left || right;
	}

	private TreeNode delete(TreeNode root, int deleteNode){
		if(root == null) return root;
		if(root.val < deleteNode) delete(root.right, deleteNode);
		else if(root.val > deleteNode) delete(root.left, deleteNode);
		else{
			if(root.left == null) return root.right;
			else if(root.right == null) return root.left;
			else{
				root = root.right;
				while(root.left != null) root = root.left;
				root.right = delete(root.right, root.val);
			}
		}
		return root;
	}

	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(){}

		public TreeNode(int val){
			this.val = val;
		}
	}
}