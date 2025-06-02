public class CoinChange_1 {

    public static void main(String[] args) {
        int target = 5;
        int[] denominations = {1,2,3};

        System.out.println("The maximum number of ways to pick coins required to target is: "+findMaximumNumberOfCombinationsToTarget(denominations, target, denominations.length));
    }

    public static int findMaximumNumberOfCombinationsToTarget(int[] denominations, int target, int n){

        int[][] dp = new int[n + 1][target + 1];

        for(int i = 0 ; i < n + 1; i++){
            for(int j = 0; j < target + 1; j++){
                if(i == 0){
                    dp[i][j] = 0;
                }
                if(j == 0){
                    dp[i][j] = 1;
                }
            }
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < target + 1; j++){
                if(denominations[i - 1] <= j){
                    dp[i][j] =  dp[i][j - denominations[i - 1]] +  dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];

    }
}
