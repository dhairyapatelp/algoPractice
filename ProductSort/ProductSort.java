import java.util.*;

class ProductSort{
	public static void main(String[] args){
		int[] arr1 = {4,5,6,5,4,3};
		int[] arr2 = {8,5,5,5,5,1,1,1,4,4};
		System.out.println(Arrays.toString(helper(arr1)));
		System.out.println(Arrays.toString(helper(arr2)));
	}

	private static int[] helper(int[] arr){
		int[] ans = new int[arr.length];
		int index = 0;
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() == b.getValue() ? 
																					   a.getKey()-b.getKey() : 
																					   a.getValue()-b.getValue()));
		for(int each: arr){
			map.put(each, map.getOrDefault(each, 0)+1);
		}
		pq.addAll(map.entrySet());

		while(!pq.isEmpty()){
			Map.Entry<Integer, Integer> each = pq.poll();
			for(int i=0; i<each.getValue(); i++){
				ans[index++] = each.getKey();
			}
		}

		return ans;
	}
}