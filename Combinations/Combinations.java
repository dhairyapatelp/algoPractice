import java.util.ArrayList;
import java.util.List;

public class Combinations{
	public static void main(String[] args){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result = combine(4, 2);
		for(List<Integer> each: result){
			System.out.println(each);
		}
	}

	private static List<List<Integer>> combine(int n, int k)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();

		helper(n, k, result, temp, 1);

		return result;
	}

	private static void helper(int n, int k, List<List<Integer>> result, List<Integer> temp, int startIndex){
		if(temp.size() == k){
			result.add(temp);
			return;
		}

		for(int i=startIndex; i<=n; i++){
			temp.add(i);
			helper(n, k, result, temp, i+1);
			temp.remove(temp.size()-1);
		}

		return;
	}
}