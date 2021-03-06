class Trie{
	static int SIZE = 26;
	static int M = 3;
	static int N = 3;

	public static void main(String args[]) 
    { 
        // Let the given dictionary be following 
        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GEE"}; 
       
        // root Node of trie 
        TrieNode root = new TrieNode(); 
       
        // insert all words of dictionary into trie 
        int n = dictionary.length; 
        for (int i=0; i<n; i++) 
            insert(root, dictionary[i]); 
       
        char boggle[][] = {{'G','I','Z'}, 
                           {'U','E','K'}, 
                           {'Q','S','E'} 
        }; 
       
        findWords(boggle, root);           
    } 

    static class TrieNode{
    	TrieNode[] child = new TrieNode[26];
		boolean isLeaf;

    	TrieNode(){
    		isLeaf = false;
    		for(int i=0; i<SIZE; i++){
    			child[i] = null;
    		}
    	}
    }

    private static void insert(TrieNode root, String word){
    	int len = word.length();
    	TrieNode beta = root;
    	for(int i=0; i<len; i++){
    		int c = word.charAt(i)-'A';
    		if(beta.child[c] == null){
    			beta.child[c] = new TrieNode();	
    		}
    		beta = beta.child[c];
    	}
    	beta.isLeaf = true;
    }

    private static void findWords(char[][] boogle, TrieNode root){
    	boolean[][] check = new boolean[M][N];
    	TrieNode beta = root;

    	String str = "";
    	for(int row=0; row<M; row++){
    		for(int col=0; col<N; col++){
    			if(beta.child[(boogle[row][col]) - 'A'] != null){
    				str = str+boogle[row][col];
    				searchWords(check, row, col, boogle, beta.child[boogle[row][col] - 'A'], str);
    				str = "";
    			}
    		}
    	}
    }

    private static void searchWords(boolean[][] check, int row, int col, char[][] boogle, TrieNode root, String str){
    	//choose
    	//explore -> check all direction including diagonals
    	//unchoose
    	
    	if(root.isLeaf==true) {
    		System.out.println(str);
    	}

    	if(isSafe(check, row, col)){
    		check[row][col] = true;

    		for(int i=0; i<SIZE; i++){
    			if(root.child[i] != null){
    				char c = (char)(i + 'A');
    				if(isSafe(check, row-1, col) && boogle[row-1][col]==c) searchWords(check, row-1, col, boogle, root.child[i], str+c);
    				if(isSafe(check, row-1, col+1) && boogle[row-1][col+1]==c) searchWords(check, row-1, col+1, boogle, root.child[i], str+c);
    				if(isSafe(check, row, col+1) && boogle[row][col+1]==c) searchWords(check, row, col+1, boogle, root.child[i], str+c);
    				if(isSafe(check, row+1, col+1) && boogle[row+1][col+1]==c) searchWords(check, row+1, col+1, boogle, root.child[i], str+c);
    				if(isSafe(check, row+1, col) && boogle[row+1][col]==c) searchWords(check, row+1, col, boogle, root.child[i], str+c);
    				if(isSafe(check, row+1, col-1) && boogle[row+1][col-1]==c) searchWords(check, row+1, col-1, boogle, root.child[i], str+c);
    				if(isSafe(check, row, col-1) && boogle[row][col-1]==c) searchWords(check, row, col-1, boogle, root.child[i], str+c);
    				if(isSafe(check, row-1, col-1) && boogle[row-1][col-1]==c) searchWords(check, row-1, col-1, boogle, root.child[i], str+c);
    			}
    		}
    		check[row][col] = false;
    	}
    }

    private static boolean isSafe(boolean[][] check, int row, int col){
		return (row>=0 && row<M && col>=0 && col<N && !check[row][col]);
    }
}