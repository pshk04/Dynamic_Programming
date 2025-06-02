import java.util.Arrays;

public class CoinChange_2 {

    public static void main(String[] args) {
        int target = 5;
        int[] denominations = {1,2,3};

        System.out.println("The minimum number of coins combinations required to make the target is: "+findMinimumCoinsCombinations(denominations, target, denominations.length));

    }

    public static int findMinimumCoinsCombinations(int[] denominations, int target, int n){

        int[][] dp = new int[n + 1][target + 1];

        for(int i = 0 ; i < n + 1; i++){
            for(int j = 0; j < target + 1; j++){
                if(i == 0 || (i == 1 && ((j % denominations[i]) != 0))){
                    dp[i][j] = Integer.MAX_VALUE - 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        for(int[] row : dp){
            System.out.println(Arrays.toString(row));
        }

        for(int i = 2; i < n + 1; i++){
            for(int j = 1; j < target + 1; j++){
                if(denominations[i - 1] <= j){
                    if( j == 3 && i == 2){
                        System.out.println("Here: "+(1 + dp[i][j - denominations[i - 1]]));
                    }
                    dp[i][j] =  Math.min((1 + dp[i][j - denominations[i - 1]]) ,  dp[i - 1][j]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println("------------------------------");

        for(int[] row : dp){
            System.out.println(Arrays.toString(row));
        }

        return dp[n][target];

    }
}
