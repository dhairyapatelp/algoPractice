import java.util.*;
import java.lang.*;

class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int[] nums = {-1, 3, 4, 5, 2, 6, 7, 8, 9};
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        System.out.println(obj.lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        
        for(int i=0; i<dp.length; i++) max = Math.max(max, dp[i]);
        return max;
    }
}