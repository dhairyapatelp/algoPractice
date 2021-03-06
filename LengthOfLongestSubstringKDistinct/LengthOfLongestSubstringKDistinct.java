class LengthOfLongestSubstringKDistinct {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
    }
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res=0, i=0, num=0;
        int[] count = new int[256];
        for(int j=0; j<s.length(); j++){
            if(count[s.charAt(j)]++ == 0) num++;
            while(num>k && i<s.length()){
                count[s.charAt(i)]--;
                if(count[s.charAt(i)] == 0) num--;
                i++;
            }
            res = Math.max(res, j-i+1);
        }
        
        return res;
    }
}