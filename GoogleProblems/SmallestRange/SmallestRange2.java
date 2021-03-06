package GoogleProblems.SmallestRange;

import java.util.List;

public class SmallestRange2 {

    public static void main(String[] args){
        int[] zero = {4, 10, 15, 24, 26};
        int[] one = {0, 9, 12, 20};
        int[] two = {5, 15, 22, 30};

        int range = Integer.MAX_VALUE;
        int[] ans = new int[2];

    }

    public int[] findSmallestRange(List<List<Integer>> list){
        int k = list.size();
        return new int[1];
    }

    private int findSmallestNumber(int x, int y, int z){
        return Math.min(x, Math.min(y, z));
    }

    private int findMaximumNumber(int x, int y, int z){
        return Math.max(x, Math.max(y, z));
    }
}
