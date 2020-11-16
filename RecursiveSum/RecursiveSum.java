class RecursiveSum{
	public static void main(String[] args){
		RecursiveSum obj = new RecursiveSum();
		System.out.println(obj.sum(1000000000));
	}
	
	public int sum(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 1;

		int prev = 1;
		int prevPrev = 1;
		int ans = 0;
		int count = 3;
		while(count <= n){
			int prevTemp = prev;
			int prevVal = 0;
			int prevPrevVal = 0;

			if(prev > 9){
				while(prev > 9){
					prevVal += prev % 10;
					prev = prev / 10;
				}
				 prevVal += prev;
			}
			else prevVal = prev;

			if(prevPrev > 9){
				while(prevPrev > 9){
					prevPrevVal += prevPrev % 10;
					prevPrev = prevPrev / 10;
				}
				 prevPrevVal += prevPrev;	
			}
			else prevPrevVal = prevPrev;

			prev = prevVal + prevPrevVal;
			prevPrev = prevTemp;
			count ++;
		}

		return prev;
	}
}