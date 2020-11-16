class IndividualDigitSum{
	public static void main(String[] args){
		int n = 21;
		int sum = 0;
		while(n>9){
			sum += n % 10;
			n = n/10;
		}
		sum += n;
		System.out.println(sum);
	}
}