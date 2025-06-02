package MatrixChainMultiplication;

import java.util.Arrays;

public class EggDroppingRecursive {

    public static int[][] dp;
    public static void main(String[] args) {
        int totalEggs = 2, numberOfFloors = 100;
        dp = new int[totalEggs + 1][numberOfFloors + 1];

        for(int i = 0 ; i < totalEggs + 1; i++){
            for(int j = 0; j < numberOfFloors + 1; j++){
                dp[i][j] = -1;
            }
        }

//        System.out.println("The minimum number of attempts required to find the threshold floor are: "+findThresholdFloorRecursive(totalEggs, numberOfFloors));

        System.out.println("The minimum number of attempts required to find the threshold floor are: "+findThresholdFloorDP(totalEggs, numberOfFloors));

//        for(int[] row : dp){
//            System.out.println(Arrays.toString(row));
//        }
    }

    public static int findThresholdFloorRecursive(int eggs, int floors) {

        if (floors == 0 || floors == 1) {
            return floors;
        }

        if (eggs == 1) {
            return floors;
        }

        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= floors; k++) {
            int temp = 1 +
                    Math.max(findThresholdFloorRecursive(eggs - 1, k - 1),
                    findThresholdFloorRecursive(eggs, floors - k));
            min = Math.min(min, temp);
        }

        return min;

    }
    public static int findThresholdFloorDP(int eggs, int floors){

        if(floors == 0 || floors == 1){
            return floors;
        }

        if(eggs == 1){
            return floors;
        }

        if(dp[eggs][floors] != -1){
            return dp[eggs][floors];
        }

        int min = Integer.MAX_VALUE;
        int low = 0, high = 0;

        for(int k = 1; k <= floors; k++){

            if(dp[eggs - 1][k - 1] != -1){
                low = dp[eggs - 1][k - 1];
            }else{
                low = findThresholdFloorDP(eggs - 1, k - 1);
                dp[eggs - 1][k - 1] = low;
            }

            if(dp[eggs][floors - k] != -1){
                high = dp[eggs][floors - k];
            }else{
                high = findThresholdFloorDP(eggs, floors - k);
                dp[eggs][floors - k] = high;
            }

            int temp = 1 + Math.max(low, high);

            if(eggs == 3 && floors == 5) {
                System.out.println(k + " : " + eggs + " : " + floors + " : " + temp);
            }

            min = Math.min(min, temp);
        }

        dp[eggs][floors] = min;

        return min;
    }

}
