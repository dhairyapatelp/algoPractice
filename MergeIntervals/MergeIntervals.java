import java.util.*;

class MergeIntervals {
    public static void main(String[] args){
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MergeIntervals obj = new MergeIntervals();

        for(int[] each: obj.merge(intervals)){
            System.out.println(each[0]+","+each[1]);
        }
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        
        int[] curr = intervals[0];
        int st = curr[0];
        int en = curr[1];
        List<int[]> list = new ArrayList<>();
        list.add(curr);
        for(int i=0; i<intervals.length; i++){
            if(curr[1]>=intervals[i][0]){
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
            else{
                list.add(intervals[i]);
                curr = intervals[i];
            }
        }
        
        return list.toArray(new int[list.size()][]);
    }
}