public class QuickSort{
	public static void main(String[] args){
		int[] nums = {3,2,1,4,7,5,6};

		QuickSort sort = new QuickSort();
		sort.sortImplementation(nums, 0, nums.length-1);
		sort.printArray(nums);
	}

	private void printArray(int[] nums){
		System.out.println("==========");
		for(int each: nums) System.out.println(each);
		System.out.println("==========");
	}

	private void sortImplementation(int[] nums, int low, int high){
		if(low < high){
			int partitionIndex = partition(nums, low, high);
			sortImplementation(nums, low, partitionIndex-1);
			sortImplementation(nums, partitionIndex, high);
		}
	}

	private int partition(int[] nums, int low, int high){
		int pivot = nums[high];
		int i = low-1;

		for(int j=low; j<high; j++){
			if(nums[j]<pivot){
				i++;
				swapValues(nums, i, j);
			}
		}
		swapValues(nums, i+1, high);
		
		return i+1;
	}

	private void swapValues(int[] nums, int valToSwap, int swapWithThisValue){
		int temp = nums[valToSwap];
		nums[valToSwap] = nums[swapWithThisValue];
		nums[swapWithThisValue] = temp;

		return;
	}
}