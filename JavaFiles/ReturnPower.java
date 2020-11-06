
class ReturnPower{
	public static void main(String[] args){
		System.out.println(findPower(2, 3));
	}

	public static double findPower(int x, int power){
		int sign = 1;
		if(power<0){
			sign = -1;
			power *= sign;
		} 
		double ans = helper(x, power);
		if(sign == -1) return 1/ans;
		return ans;
	}
	private static double helper(int x, int power){
		if(power == 0) return 1;
		return x*helper(x, power-1);
	}
}