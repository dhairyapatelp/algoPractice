class KnightsTour{
	static int n = 0;
	public static void main(String[] args){
		n = 8;
		int[][] board = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				board[i][j]=-1;
			}
		}
		
		boolean isValid = helper(board, 0, 0, 0);
		if(isValid)
		{
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(board[i][j]+"\t");
			}
			System.out.println();
		}
	}
	}

	public static boolean helper(int[][] board, int row, int col, int count){
		if(n*n == count) return true;
		if(!isValidMove(board, row, col)) return false;
		board[row][col] = count;
		if(helper(board, row-2, col-1, count+1) ||
		helper(board, row-1, col-2, count+1) ||
		helper(board, row+2, col-1, count+1) ||
		helper(board, row+1, col-2, count+1) ||
		helper(board, row-2, col+1, count+1) ||
		helper(board, row-1, col+2, count+1) ||
		helper(board, row+2, col+1, count+1) ||
		helper(board, row+1, col+2, count+1)) return true;

		board[row][col] = -1;
		return false;
	}

	public static boolean isValidMove(int[][] board, int row, int col){
		if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col] != -1) {
			return false;	
		}
		return true;
	}
}