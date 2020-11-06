class exam{
	public static void solution(int N){
		int p = N % 10;
		while(N > 0){
			if(p == 0 && N % 10 != 0){
				p = 1;
			}
			if(p >= 1){
				System.out.println(N%10);
			}
			N = N/10;
		}
		
	}

	public static void main(String[] args){
		solution(100);
	}
}