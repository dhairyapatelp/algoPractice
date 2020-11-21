import java.util.*;

class SubarraySum {
    public static void main(String[] args){
        int[] nums = {1, 2, 1, -2, 2, 0};
        int k = 3;
        SubarraySum obj = new SubarraySum();
        System.out.println(obj.sum(nums, k));
    }

    public int sum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int ans = 0;
        int total = 0;
        
        for(int i=0; i<nums.length; i++){
            total += nums[i];
            if(map.containsKey(total-k)){
                ans += map.get(total-k);
            }
            map.put(total, map.getOrDefault(total, 0)+1);
        }
        
        return ans;
    }
}