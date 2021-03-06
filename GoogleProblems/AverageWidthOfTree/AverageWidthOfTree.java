/*
Given an N-ary Tree, find out the average width of each of the nodes present in that tree.
Example:
          1
        /   \
       2     3
      / \   / \
     4   5 6   7
    /
   8
  /
 9
Note: A node can have ‘N’ number of children
Explanation: Consider the above tree, for node 1 , the average width would be the total no. of nodes under that node
ie. 7 (including the target node) divided by the total number of levels under the parent node (7/3) .
The format of the answer should be: [node number : average width of that node ] that is ,for the given tree the answer is :

Output:
[ 1 : 2.3 , 2 : 1.5 , 3 : 1.5 , 4 : 1 , 5 : 1 , 6 : 1 , 7 : 1 ]
*/
package GoogleProblems.AverageWidthOfTree;
import java.util.*;

public class AverageWidthOfTree {
    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
        public Node(Node left, Node right, int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args){
        Node t = new Node(1);
        AverageWidthOfTree avg = new AverageWidthOfTree();
        t.left = new Node(2);
        t.right = new Node(3);
        t.left.left = new Node(4);
        t.left.left.left = new Node(8);
        t.left.left.left.left = new Node(9);
        t.left.right = new Node(5);
        t.right.left = new Node(6);
        t.right.right = new Node(7);

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Double> averageWidth = new HashMap<>();
        avg.dfs(t, 1, list, map);
        averageWidth = avg.getAverageWidthOfTree(list, map);
        for(List<Integer> each: list) System.out.println(each);
        for(Integer each: averageWidth.keySet()){

            System.out.println(each+":"+averageWidth.get(each));
        }

    }
    private Map<Integer, Double> getAverageWidthOfTree(List<List<Integer>> list, Map<Integer, Integer> map){
        Map<Integer, Double> averageWidth = new HashMap<>();
        for(int i=0; i<list.size(); i++){
            for(Integer each: list.get(i)){
                int levelBelow = list.size()-i;
                int nodes = map.get(each);
                averageWidth.put(each, (double)nodes/levelBelow);
            }
        }
        return averageWidth;
    }
    private int dfs(Node root, int level, List<List<Integer>> list, Map<Integer, Integer> map){
        if(root == null) return 0;
        if(list.size()<level){
            list.add(new ArrayList<>());
        }
        list.get(level-1).add(root.val);
        int left = dfs(root.left, level+1, list, map);
        int right = dfs(root.right, level+1, list, map);
        map.put(root.val, left+right+1);
        return left+right+1;
    }
}
