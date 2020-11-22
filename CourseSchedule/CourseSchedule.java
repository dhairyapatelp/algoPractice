import java.util.*;

class CourseSchedule {
    public static void main(String[] args){

    }
    
    public boolean canFinish(int num, int[][] pre) {
        int[] in = new int[num];
        ArrayList[] list = new ArrayList[num];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        for(int i=0; i<num; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<pre.length; i++){
            in[pre[i][1]]++;
            list[pre[i][0]].add(pre[i][1]);
        }
        
        for(int i=0; i<in.length; i++){
            if(in[i] == 0){
                q.add(i);
                count++;
            }
        }
        
        while(!q.isEmpty()){
            int each = q.poll();
            for(int i=0; i<list[each].size(); i++){
                int val = (int)list[each].get(i);
                in[val]--;
                if(in[val] == 0) {
                    count++;
                    q.add(val);
                }
            }
        }
        
        return count == num;
    }
}