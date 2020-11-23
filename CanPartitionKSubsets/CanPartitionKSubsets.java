class CanPartitionKSubsets {
    public static void main(String[] args){
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4; 

        CanPartitionKSubsets obj = new CanPartitionKSubsets();
        System.out.println(obj.partitionKSubsets(nums, k));
    }
    public boolean partitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        int total = 0;
        for(int each: nums) total += each;
        if(k == 0 || total%k != 0) return false;
        boolean[] check = new boolean[nums.length];
        
        return helper(nums, check, k, 0, total/k, 0);
    }
    
    public boolean helper(int[] nums, boolean[] check, int k, int rolling, int total, int index){
        if(k == 1) return true;
        if(rolling == total){
            return helper(nums, check, k-1, 0, total, 0);
        }
        if(rolling > total) return false;
        for(int i=index; i<nums.length; i++){
            if(check[i] ) continue;
            check[i] = true;
            if(helper(nums, check, k, rolling+nums[i], total, i+1)) return true;
            check[i] = false;
        }
        
        return false;
    }
}