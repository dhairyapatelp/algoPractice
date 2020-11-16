import java.util.Random; 

class RandomNumberGenerator{
	public static void main(String[] args){
		Random rand = new Random();

		int rand1 = rand.nextInt(1500);
		System.out.println(rand1);
	}
}