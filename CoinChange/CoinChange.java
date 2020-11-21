import java.lang.*;
import java.util.*;

class CoinChange {
    
    public static void main(String[] args){
        int[] coins = {1, 2, 5};
        CoinChange obj = new CoinChange();
        System.out.println(obj.change(coins, 11));
    }

    public int change(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        
        for(int i=1; i<amount+1; i++){
            for(int j=0; j<coins.length;  j++){
                if(coins[j]>i) continue;
                else{
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}

//https://www.youtube.com/watch?v=jgiZlGzXMBw&ab_channel=BackToBackSWE