import java.util.Arrays;

public class UnboundedKnapsack{

    public static void main(String[] args) {
        int[] weights = {1,2,3,5};
        int[] values = {1,5,4,8};
        int capacity = 6;

        System.out.println("The max value of the unbounded knapsack is: "+findMaxValueOfUnboundedKnapsack(capacity, weights, values));
    }

    public static int findMaxValueOfUnboundedKnapsack(int capacity, int[] weights, int[] values){
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for(int i = 0; i < (n + 1); i++){
            for(int j = 0; j < (capacity + 1); j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1 ; i < (n + 1); i++){
            for(int j = 1; j < (capacity + 1); j++){
                if(weights[i - 1] <= j) {
                    dp[i][j] = Math.max((values[i - 1] + dp[i][j - weights[i - 1]]), dp[i - 1][j]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for(int[] row : dp){
            System.out.println(Arrays.toString(row));
        }

        return dp[n][capacity];
    }
}
