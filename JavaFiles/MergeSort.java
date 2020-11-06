public class MergeSort{
	public static void main(String[] args){
		int[] nums = {9,8,7,6,5,4,3,2,4,6,2,5,1};
		int [] temp = new int[nums.length];
		MergeSort obj = new MergeSort();
		obj.sort(nums, 0, nums.length-1);
		for(int each: nums) System.out.println(each);
	}

	private void sort(int[] nums, int left, int right){
		if(left>=right){
			return;
		}
		int mid = (left+right)/2;
		sort(nums, left, mid);
		sort(nums, mid+1, right);
		mergeHalves(nums, left, right);

	}

	private void mergeHalves(int[] nums, int leftStart, int rightEnd){
		int[] temp = new int[nums.length];
		for(int i=leftStart; i<=rightEnd; i++){
			temp[i] = nums[i];
		}

		int leftEnd = (leftStart + rightEnd )/2;
		int rightStart = leftEnd + 1;
		int index = leftStart; 
		while(leftStart<=leftEnd && rightStart<=rightEnd){
			if(temp[leftStart]<=temp[rightStart]){
				nums[index++] = temp[leftStart++];
			}
			else{
				nums[index++] = temp[rightStart++];
			}
		}
		while(leftStart<=leftEnd){
			nums[index++] = temp[leftStart++];
		}
		while(rightStart<=rightEnd){
			nums[index++] = temp[rightStart++];
		}

	}
}