public class RodCutting {

    public static void main(String[] args) {
         int[] lengths = {1,2,3,4,5,6,7,8};
         int[] price =   {1,5,8,9,10,17,17,20};
         int maxLength = 8;
        System.out.println("The ratio cuts with max profit is: "+findMaxProfitCutRatios(lengths, price, maxLength));
    }

    public static int findMaxProfitCutRatios(int[] lengths, int[] price, int maxLength){
        int[][] dp = new int[maxLength + 1][lengths.length + 1];

        for(int i = 0 ; i < maxLength + 1; i++){
            for(int j = 0 ; j < lengths.length + 1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < maxLength + 1; i++){
            for(int j = 1; j < lengths.length + 1; j++){
                if(lengths[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i - 1][j - lengths[i - 1]], dp[i - 1][j]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[lengths.length][maxLength];
    }
}
