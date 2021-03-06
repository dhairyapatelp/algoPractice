package com.algoPractice.BinarySearch;

public class BinarySearch {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,8,10,16,23};
        System.out.println(binarySearch(nums, 6));
    }

    private static int binarySearch(int[] nums, int k){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == k) return mid;
            else if(nums[mid]>k) right = mid-1;
            else if(nums[mid]<k) left = mid+1;
        }

        return -1;
    }
}
