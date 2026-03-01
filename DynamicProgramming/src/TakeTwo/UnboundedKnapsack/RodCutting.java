package TakeTwo.UnboundedKnapsack;

public class RodCutting {

    public static void main(String[] args) {
        int[] lengths = {1,2,3,4,5,6,7,8};
        int[] prices = {1,5,8,9,10,17,17,20};
        int n = 8;
        System.out.println("The cuts in the given rod that makes maximum profit is: "+findMaxProfit(lengths, prices, n));
    }

    public static int findMaxProfit(int[] lengths, int[] prices, int n){

        int[][] storage = new int[prices.length + 1][lengths.length + 1];

        for(int i = 0; i < lengths.length + 1; i++){
            for(int j = 0 ; j < n + 1; j++){
                if(i == 0 || j == 0) {
                    storage[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < lengths.length + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(lengths[i - 1] <= j){
                    storage[i][j] = Math.max(prices[i - 1] + storage[i - 1 ][j - lengths[i - 1]], storage[i - 1][j]);
                }else{
                    storage[i][j] = storage[i - 1][j];
                }
            }
        }
        return storage[lengths .length][n];
    }
}
