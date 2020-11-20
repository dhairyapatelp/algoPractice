import java.lang.*;

public class BucketSort{
	public static void main(String[] args){
		BucketSort obj = new BucketSort();
		int[] toBeSorted = {3, 5, 2, 0, 7};

		int maxVal = obj.maxVal(toBeSorted);
		toBeSorted = obj.sort(toBeSorted, maxVal);

		for(int each: toBeSorted) System.out.println(each);
	}

	public int[] sort(int[] nums, int maxVal){
		int[] bucket = new int[maxVal+1];
		int[] sorted = new int[nums.length];
		int ptr = 0;

		for(int i=0; i<nums.length; i++){
			bucket[nums[i]]++;
		}

		for(int i=0; i<bucket.length; i++){
			for(int j=0; j<bucket[i]; j++){
				sorted[ptr++] = i;
			}
		}

		return sorted;
	}
	public int maxVal(int[] nums){
		int max = Integer.MIN_VALUE;
		for(int each: nums){
			max = Math.max(max, each);
		}

		return max;
	}
}