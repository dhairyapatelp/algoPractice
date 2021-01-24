class MinFallingPathSum {
    public static void main(String[] args){
        MinFallingPathSum obj = new MinFallingPathSum();
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(obj.minFallingPathSum(a));
    }
    public int minFallingPathSum(int[][] a) {
        int ans = Integer.MAX_VALUE;
        for(int i=1; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                int min = Integer.MAX_VALUE;
                for(int each=j-1; each<=j+1; each++){
                    if(isValid(a, i-1, each)){
                        int val = a[i-1][each];
                        min = Math.min(min, a[i-1][each]);    
                    }
                }
                int val = a[i][j];
                a[i][j] += min;
            }
        }
        for(int i=0; i<a.length; i++){
            ans = Math.min(ans, a[a.length-1][i]);
        }
        return ans;
    }
    
    private boolean isValid(int[][] a, int row, int col){
        return (row>=0 && row<a.length && col>=0 && col<a[0].length);
    }
}