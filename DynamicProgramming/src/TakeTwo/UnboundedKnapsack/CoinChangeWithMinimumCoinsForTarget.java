package TakeTwo.UnboundedKnapsack;

public class CoinChangeWithMinimumCoinsForTarget {

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int target = 5;
        System.out.println("Minimum number of coins required to make the target: "+findMinimumCoinsForSum(coins, target));
    }

    public static int findMinimumCoinsForSum(int[] coins, int target){
        int[][] storage = new int[coins.length + 1][target + 1];

        for(int i = 0 ; i < coins.length + 1; i++){
            for(int j = 0 ; j < target + 1; j++){
                if(i == 0) {
                    storage[i][j] = Integer.MAX_VALUE - 1;
                }else if(j == 0){
                    storage[i][j] = 0;
                }else if(i == 1) {
                    if(coins[i - 1] < j){
                        storage[i][j] = Integer.MAX_VALUE - 1;
                    }else{
                        storage[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 2 ; i < coins.length + 1; i++){
            for(int j = 1 ; j < target + 1; j++){
                if(coins[i - 1] <= j){
                    storage[i][j] = Math.min(1 + storage[i][j - coins[i - 1]], storage[i - 1][j]);
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
