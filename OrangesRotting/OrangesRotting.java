import java.util.*;

class OrangesRotting {
    public static void main(String[] args){
        int[][] oranges = {{2, 1, 1},
                           {1, 1, 0},
                           {0, 1, 1}};
        OrangesRotting obj = new OrangesRotting();
        System.out.println(obj.orangesRotting(oranges));

    }
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }
        if(fresh == 0) return 0;
        int count = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()){
            count ++;
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] each = q.poll();
                for(int[] dir: dirs){
                    int x = each[0] + dir[0];
                    int y = each[1] + dir[1];
                    
                    if(x<0 || y<0 || x>=row || y>=col || grid[x][y] == 2 || grid[x][y] == 0) continue;
                    grid[x][y] = 2;
                    fresh--;
                    q.add(new int[]{x, y});
                }
            }
        }
        
        return fresh == 0 ? count-1: -1;
    }
}