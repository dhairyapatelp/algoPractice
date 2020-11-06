public class MedianOfTwoSortedArray{
	public static void main(String[] args){
		MedianOfTwoSortedArray obj = new MedianOfTwoSortedArray();
		int[] a = {1,3};
		int[] b = {2};
		System.out.println(obj.getMedian(a, b));
	}

	private double getMedian(int[] a, int b[]){
		if(a.length>b.length){
			return getMedian(b, a);
		}

		int aLen = a.length;
		int bLen = b.length;

		int low = 0;
		int high = aLen;

		while(low<=high){
			int partA = (low+high)/2;
			int partB = ((aLen + bLen+1)/2)-partA;

			int maxLeftA = (partA==0) ? Integer.MIN_VALUE : a[partA-1];
			int minRightA = (partA==aLen) ? Integer.MAX_VALUE : a[partA];

			int maxLeftB = (partB==0) ? Integer.MIN_VALUE : b[partB-1];
			int minRightB = (partB==bLen) ? Integer.MAX_VALUE : b[partB];

			if(maxLeftA <= minRightB && maxLeftB <= minRightB){
				if(aLen+bLen%2==0) return (double)(Math.max(maxLeftA, maxLeftB) + Math.min(maxLeftB, maxLeftA))/2;
				else{
					return (double)Math.max(maxLeftA, maxLeftB);
				}
			}
			else if(maxLeftA>minRightB){
				high = partA-1;
			}
			else{
				low = partA+1;
			}
		}

		return -1;
	}
}

//partition of smaller array would be (low + high)/2
//partition of larger array would be (x.length + y.length)/2 - small.partition 
//found if maxLeft.x is less than minRight.y and maxLeft.y is less than minRight.x
//if if maxLeft.x is greater than minRight.y move x pointer to left
//else move pointer on right in y
