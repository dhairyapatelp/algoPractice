/*
* You have k lists of sorted integers. Find the smallest range that includes at least one number from each of the k lists.

For example,
List 1: [4, 10, 15, 24, 26]
List 2: [0, 9, 12, 20]
List 3: [5, 18, 22, 30]

The smallest range here would be [20, 24] as it contains 24 from list 1, 20 from list 2, and 22 from list 3.

*/
package GoogleProblems.SmallestRange;

import java.util.*;

public class SmallestRange1 {
    private class Data{
        int data;
        int listNo;

        public Data(int data, int listNo){
            this.listNo = listNo;
            this.data = data;
        }
    }

    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<List<Integer>>(){};
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(10);
        list1.add(15);
        list1.add(24);
        list1.add(26);

        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(9);
        list2.add(12);
        list2.add(20);

        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        list3.add(18);
        list3.add(22);
        list3.add(30);

        list.add(list1);
        list.add(list2);
        list.add(list3);

        SmallestRange1 obj = new SmallestRange1();
        int[] ans = obj.findSmallestRange(list);
        System.out.println("Range: "+ (ans[1]-ans[0]));
        System.out.println("First: "+ans[0]+", Last: "+ans[1]);
    }

    public int[] findSmallestRange(List<List<Integer>> input){
        PriorityQueue<Data> pq = new PriorityQueue<Data>((d1, d2) -> d1.data - d2.data);
        SortedSet<Data> set = new TreeSet<>((d1, d2) -> d1.data - d2.data);
        Map<Integer, Data> dataToListNo = new HashMap<>();
        int minRange = Integer.MAX_VALUE;
        int k = input.size();
        int[] range = new int[2];
        for(int i=0; i<input.size(); i++){
            if(input.get(i).size() > 0){
                int val = input.get(i).remove(0);
                pq.add(new Data(val, i));
            }
        }

        while(!pq.isEmpty()){
            Data node = pq.poll();
            int listNo = node.listNo;
            if(input.get(listNo).size() > 0){
                int val = input.get(listNo).remove(0);
                pq.add(new Data(val, listNo));
            }

            if(dataToListNo.size() == k){
                Data first = set.first();
                Data last = set.last();
                if(minRange > last.data - first.data+1){
                    range[0] = first.data;
                    range[1] = last.data;
                    minRange = last.data - first.data+1;
                }
                set.remove(first);
                dataToListNo.remove(first.listNo);
            }
            if(dataToListNo.containsKey(listNo)){
                set.remove(dataToListNo.remove(listNo));
            }
            dataToListNo.put(node.listNo, node);
            set.add(node);
        }

        if(dataToListNo.size() == k){
            Data first = set.first();
            Data last = set.last();
            if(minRange > last.data - first.data+1){
                range[0] = first.data;
                range[1] = last.data;
                minRange = last.data - first.data;
            }
            set.remove(first);
            dataToListNo.remove(first.listNo);
        }

        return range;
    }
}
