/*
There is an island which is represented by square matrix NxN.
A person on the island is standing at any given co-ordinates (x,y). He can move in any direction one step right, left, up, down on the island. If he steps outside the island, he dies.

Let island is represented as (0,0) to (N-1,N-1) (i.e NxN matrix) & person is standing at given co-ordinates (x,y). He is allowed to move n steps on the island (along the matrix). What is the probability that he is alive after he walks n steps on the island?

Write a psuedocode & then full code for function
" float probabilityofalive(int x,int y, int n) ".


* */
package GoogleProblems.ProbabilityOfAlive;

import java.util.*;

public class ProbabilityOfAlive {
    public static void main(String[] args){
        ProbabilityOfAlive obj = new ProbabilityOfAlive();
        System.out.println("probability1 = " + obj.probabilityOfAlive(0, 0, 1));
        System.out.println("probability2 = " + obj.probabilityOfAlive(0, 0, 2));
        System.out.println("probability3 = " + obj.probabilityOfAlive(0, 0, 3));

    }

    public double probabilityOfAlive(int row, int col, int steps){
        if(row<0 || col<0 || row>steps-1 || col>steps-1 || steps<1) return 0.0;
        return checkIfAlive(row, col, steps, steps, new HashMap<>());
    }

    public double checkIfAlive(int row, int col, int N, int steps, Map<String, Double> map){
        if(steps == 0) return 1.0;
        if(row<0 || col<0 || row>N-1 || col>N-1) return 0.0;
        String val = row+","+col+"."+steps;

        if(map.containsKey(val)) return map.get(val);
        double prob = 0.0;
        if(row>=0) prob += 0.25 * checkIfAlive(row-1, col, N, steps-1, map);
        if(col>=0) prob += 0.25 * checkIfAlive(row, col-1, N, steps-1, map);
        if(row<(N-1)) prob += 0.25 * checkIfAlive(row+1, col, N, steps-1, map);
        if(col<(N-1)) prob += 0.25 * checkIfAlive(row, col+1, N, steps-1, map);
        map.put(val, prob);

        return prob;
    }
}
