package GoogleProblems.RangeSumQuery2DMutable;

public class RangeSumQuery2DMutable {
        private int[][] colSums;
        private int[][] matrix;

        public RangeSumQuery2DMutable(int[][] matrix) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return;
            }
            this.matrix = matrix;

            int m   = matrix.length;
            int n   = matrix[0].length;
            colSums = new int[m + 1][n];

            for(int i = 1; i <= m; i++){
                for(int j = 0; j < n; j++){
                    colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
                }
            }
        }
        //time complexity for the worst case scenario: O(m)
        public void update(int row, int col, int val) {
            for(int i = row + 1; i < colSums.length; i++){
                colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
            }

            matrix[row][col] = val;
        }
        //time complexity for the worst case scenario: O(n)
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ret = 0;

            for(int j = col1; j <= col2; j++){
                ret += colSums[row2 + 1][j] - colSums[row1][j];
            }

            return ret;
        }
    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * obj.update(row,col,val);
     * int param_2 = obj.sumRegion(row1,col1,row2,col2);
     */
    public static void main(String[] args){
        /*
        ["NumMatrix","sumRegion","update","sumRegion"]
        [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[3,2,2],[2,1,4,3]]
        * */
        int[][] matrix = {{3,0,1,4,2},
                          {5,6,3,2,1},
                          {1,2,0,1,5},
                          {4,1,0,1,7},
                          {1,0,3,0,5}};
        RangeSumQuery2DMutable num = new RangeSumQuery2DMutable(matrix);
        num.sumRegion(2, 1, 4, 3);
        num.update(3, 2, 2);
        num.sumRegion(2, 1, 4, 3);
    }
}
