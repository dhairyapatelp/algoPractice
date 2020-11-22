
class RotateArray {
    public static void main(String[] args){
        RotateArray obj = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        obj.rotateIteratively(nums, 3);
        for(int each: nums){
            System.out.println(each);
        }
        System.out.println("===========");
        obj.rotateReverse(nums, 3);
        for(int each: nums){
            System.out.println(each);
        }
    }
    public void rotateIteratively(int[] nums, int k) {
        k %= nums.length;
        int len = nums.length; 
        int count = 0;
        for(int i=0; count<len; i++){
            int curr = i;
            int prev = nums[i];
            do{
                count++;
                int ind = (curr+k)%len;
                int temp = nums[ind];
                nums[ind] = prev;
                prev = temp;
                curr = ind;
                
            }while(i!=curr);
        }   
    }

    public void rotateReverse(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }
    
    public void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[end];
            nums[end--] = nums[start];
            nums[start++] = temp;
        }
    }

}