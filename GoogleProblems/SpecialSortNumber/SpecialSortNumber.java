/*Give you an array which has n integers,it has both positive and negative integers.
Now you need sort this array in a special way.After that,the negative integers should
in the front,and the positive integers should in the back.Also the relative position
should not be changed.

eg. -1 1 3 -2 2 ans: -1 -2 1 3 2.
o(n)time complexity and o(1) space complexity is perfect.
* */
package GoogleProblems.SpecialSortNumber;

public class SpecialSortNumber {
    static int[] nums = {-1, 1, -2, -22, 7, -4};
    public static void main(String[] args){
        SpecialSortNumber obj = new SpecialSortNumber();
        specialSort(nums);
        for(int each: nums) System.out.println(each);
    }

    public static void specialSort(int[] nums){
        int n = 0;
        int[] neg = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums[i]<0) neg[n++] =  nums[i];
        }
        int negCount = 0;
        for(int i=nums.length-1; i>=0; i--){
            if(negCount>0 && nums[i]>=0) nums[i+negCount] = nums[i];
            else if(nums[i]<0) negCount++;
        }
        for(int i=0; i<n; i++){
            nums[i] = neg[i];
        }
    }
}
