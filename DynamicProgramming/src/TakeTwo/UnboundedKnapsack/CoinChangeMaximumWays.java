package TakeTwo.UnboundedKnapsack;

public class CoinChangeMaximumWays {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int target = 5;
        System.out.println("Maximum number of coins required to make the target: "+findMaximumCoinsForSum(coins, target));
    }

    public static int findMaximumCoinsForSum(int[] coins, int target){
        int[][] storage = new int[coins.length + 1][target + 1];

        for(int i = 0 ; i < coins.length + 1; i++){
            for(int j = 0 ; j < target + 1; j++){
                if(i == 0) {
                    storage[i][j] = 0;
                }
                if(i == 0 && j == 0){
                    storage[i][j] = 1;
                }else if(j == 0){
                    storage[i][j] = 1;
                }
            }
        }

        for(int i = 1 ; i < coins.length + 1; i++){
            for(int j = 1 ; j < target + 1; j++){
                if(coins[i - 1] <= j){
                    storage[i][j] = storage[i][j - coins[i - 1]] + storage[i - 1][j];
                }else{
                    storage[i][j] = storage[i - 1][j];
                }
            }
        }
        for(int i = 0 ; i < coins.length + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                System.out.print(storage[i][j] + " ");
            }
            System.out.println();
        }
        return storage[coins.length][target];
    }
}

