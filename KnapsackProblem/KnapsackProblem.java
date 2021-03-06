package KnapsackProblem;

public class KnapsackProblem {

    public static void main(String[] args){
        int profit[] = {1, 2, 5, 6};
        int weight[] = {2, 3, 4, 5};
        int capacity = 8;

        System.out.println(findMaxProfit(profit, weight, capacity));

    }

    private static int findMaxProfit(int[] profit, int weight[], int capacity){
        int[][] dp = new int[profit.length+1][capacity+1];

        for(int row=0; row<dp.length; row++){
            for(int col=0; col<dp[0].length; col++){
                if(row == 0 || col == 0){
                    dp[row][col] = 0;
                    continue;
                }
                if(col-weight[row-1]>=0){
                    dp[row][col] = Math.max(dp[row-1][col], dp[row-1][col-weight[row-1]]+profit[row-1]);
                }
                else{
                    dp[row][col] = dp[row-1][col];
                }
            }
        }
        return dp[profit.length][capacity];
    }
}
