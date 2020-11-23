import java.util.*;

class CombinationSumII {
    public static void main(String[] args){
        CombinationSumII obj = new CombinationSumII();
        int[] can = {10,1,2,7,6,1,5};
        int tar = 8;
        obj.combinationSum2(can, tar);
    }
    public List<List<Integer>> combinationSum2(int[] can, int tar) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(can);
        
        helper(can, list, temp, 0, tar);
        return list;
    }
    
    public void helper(int[] can, List<List<Integer>> list, List<Integer> temp, int index, int tar){
        if(tar<0) return;
        else if(tar == 0){
            list.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=index; i<can.length && can[i]<=tar; i++){
            if(i>index && (can[i] == can[i-1])) continue;
            temp.add(can[i]);
            helper(can, list, temp, i+1, tar-can[i]);
            temp.remove(temp.size()-1);
        }
        
        return;
    }
}