import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {
        int[] weights = {1,2,3,5};
        int[] values = {1,5,4,8};

//        System.out.println("The max value for the knapsack using memoization is: "+knapsackMemoization(6, weights, values));
        System.out.println("The max value for the knapsack using tabulation is: "+knapsackTabulation(6, weights, values));
    }

    public static int knapsackMemoization(int capacity, int[] weights, int[] values){
        int n = values.length;
        int[] dp = new int[capacity + 1];

        for(int i = 0; i <= capacity; i++){
            dp[i] = 0;
        }

        for(int i = 0 ; i < n; i++){
            for(int j = capacity; (weights[i] <= j); j--){
                dp[j] = Math.max(values[i] + dp[j - weights[i]], dp[j]);
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[capacity];
    }

    public static int knapsackTabulation(int capacity, int[] weights, int[] values){
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
                    dp[i][j] = Math.max((values[i - 1] + dp[i - 1][j - weights[i - 1]]),
                                    dp[i - 1][j]
                                );
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
