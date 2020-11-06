class Solution {
	// 1
	// 2
	// 3
	// 4
	// 5
	// Time: O(n^2)
	// Space: O(n)
	public boolean divisorGame(int N) {
		if (N <= 1) return false;

		boolean[] res = new boolean[N+1];
		res[2] = true;

		for (int i = 3; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (i % j == 0 && res[j] == true) 
				{
					res[i] = true;
					break;
				}
			}
		}

		return res[N];
	}
}