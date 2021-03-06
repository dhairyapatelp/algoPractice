package SortingAlgorithms.QuickSort;

class QuickSort{
	public static void main(String[] args){
		int nums[] = {5,4,3,2,1};
		partition(nums, 0, nums.length-1);
		print(nums);
	}

	private static void print(int[] nums){
		for(int each: nums){
			System.out.println(each);
		}
	}
	private static void partition(int[] nums, int low, int high){
		if(low<high){
			int median = median(nums, low, high);
			partition(nums, low, median-1);
			partition(nums, median, high);	
		}
		
	}

	private static int median(int[] nums, int low, int high){
		int pivot = nums[high];
		int i = low-1;

		for(int j=low; j<high; j++){
			if(nums[j]<pivot){
				i++;
				swap(nums, i, j);
			}
		}
		swap(nums, i+1, high);
		return i+1;
	}

	private static void swap(int[] nums, int swap1, int swap2){
		int temp = nums[swap1];
		nums[swap1] = nums[swap2];
		nums[swap2] = temp;

		return;
	}
}