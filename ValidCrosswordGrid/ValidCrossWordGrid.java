package ValidCrosswordGrid;

import java.util.*;

class ValidCrosswordGrid  {
    public static int[][] input = {
                     {0,1,1,0,0},
                     {0,1,0,1,0},
                     {0,1,1,0,1},
                     {0,0,0,0,1}};

    public static int[][] input1 = {{0,0,0,0,0},
                      {1,1,1,1,0},
                      {0,0,1,0,0},
                      {1,1,1,1,0}};

    public static void main(String[] args) {
        ValidCrosswordGrid obj = new ValidCrosswordGrid();
        System.out.println(obj.isValid(input));
    }

    private int countZeros(int[][] matrix){
        int zero = 0;
        for(int row = 0; row<matrix.length; row++){
            for(int col = 0; col<matrix[0].length; col++){
                if(matrix[row][col] == 0) zero++;
            }
        }
        return zero;
    }

    private boolean isValid(int[][] matrix){
        int ans = countZeros(matrix);
        System.out.println(ans);
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int l = matrix.length;
        int m = matrix[0].length;
        Set<String> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cord = q.poll();
                for(int j=0; j<dir.length; j++){
                    int row = cord[0] + dir[j][0];
                    int col = cord[1] + dir[j][1];
                    if(row>=0 && col>=0 && row<l && col<m && !set.contains(row+","+col) && matrix[row][col] == 0){
                        set.add(row+","+col);
                        q.add(new int[]{row, col});
                        count++;
                    }
                }
            }
        }
        return ans == count;
    }
//    private int[] root;
//    private int[] rank;
//    public ValidCrosswordGrid(){}
//    public ValidCrosswordGrid(int n) {
//        root = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            root[i] = i;
//        }
//        rank = new int[n + 1];
//    }
//    int getRoot(int x) {
//    if (x != root[x]) {
//        root[x] = getRoot(root[x]);
//    }
//    return root[x];
//}
//
//    int union(int x, int y) {
//        if  (rank[x]  == rank[y])  {
//            root[y]  =  root[x];
//            rank[x]++;
//            return root[x];
//        } else if (rank[x]  <  rank[y]) {
//            root[x]  =  root[y];
//            return root[y];
//        }
//        else {
//            root[y]  =  root[x];
//            return root[x];
//        }
//    }
//    boolean isValidPuzzle(int[][] matrix) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//        ValidCrosswordGrid ds = new ValidCrosswordGrid(m * n);
//        int[] offset = new int[] {1, 1};
//        int root = -1;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m ; j++) {
//                if (matrix[i][j] == 0) {
//                    int current = i * m + j;
//                    int newRoot = ds.getRoot(current);
//                    for (int k = 0; k < 2; k++) {
//                        int r = i;
//                        int c = j;
//                        if (k == 0)
//                            c += offset[k];
//                        else
//                            r += offset[k];
//                        if (r >= n ||  c >= m )
//                            continue;
//                        if (matrix[r][c] == 0) {
//                            if (ds.getRoot(r * m + c) != ds.getRoot(current)) {
//                                newRoot = ds.union(current, r * m + c);
//                                if (root != newRoot && root != -1){
//                                    return false;
//                                }
//                                root = newRoot;
//                            }
//                        }
//                    }
//                    if (root == -1)
//                        root = newRoot;
//                    else {
//                        if (root != newRoot)
//                            return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
}


