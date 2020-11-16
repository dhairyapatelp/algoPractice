import java.util.*;

public class Swap{
	
	public static void main(String[] args){

		Swap swap = new Swap();
		int[] a = {4, 1, 2, 1, 1, 2};
		int[] b = {3, 6, 3, 3};
		List<List<Integer>> result = swap.swapNum(a, b);
		for(List<Integer> eachArr: result){
			System.out.println("["+eachArr.get(0)+", "+eachArr.get(1)+"]");
		}
	}

	private List<List<Integer>> swapNum(int[] a, int[] b){
		int suma = 0;
		int sumb = 0;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp;

		for(int each: a) suma += each;
		for(int each: b) sumb += each;

		System.out.println("Sum A: "+suma);
		System.out.println("Sum B: "+sumb);

		for(int i=0; i<a.length; i++){
			for(int j=0; j<b.length; j++){

				if(suma - a[i] + b[j] == sumb - b[j] +a[i]){
					temp = new ArrayList<Integer>();
					temp.add(a[i]);
					temp.add(b[j]);
					result.add(new ArrayList<Integer>(temp));
				}
			}
		}

		return result;
	}
}