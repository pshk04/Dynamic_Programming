import java.util.Arrays;

public class MinimumSubsetSumDifference {

    public static void main(String[] args) {
        int[][] nums = {
                {1,2,7},
                {1,5,6,11}
        };
        int sum = 0;

        for(int[] num: nums){
            for(int i = 0 ; i < num.length; i++) {
                sum += num[i];
            }
            System.out.println("The minimum subset sum difference is: "+minimumSubsetSumDifference(num, sum));
            sum = 0;
        }
    }

    public static int minimumSubsetSumDifference(int[] nums, int sum){
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        int minimumDifference = 0;

        for(int i = 0; i < nums.length + 1; i++){
            for(int j = 0; j < sum + 1; j++){
                if(i == 0){
                    dp[i][j] = false;
                }
                if(j == 0){
                    dp[i][j] = true;
                }
            }
        }

        for(int i = 1; i < nums.length + 1; i++){
            for(int j = 1; j < sum + 1; j++){
                if(nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for(boolean[] dpArray: dp){
            System.out.println(Arrays.toString(dpArray));
        }

        minimumDifference = findMinimumDifference(dp, sum, nums.length);
        return minimumDifference;
    }

    public static int findMinimumDifference(boolean[][] dp, int range, int len){
        int minimum = Integer.MAX_VALUE;
        int rangeByTwo = range/2;

        for(int i = 0; i <= rangeByTwo; i++){
            if(dp[len][i] == true) {
                minimum = Math.min(minimum, range - (2 * i));
            }
        }
        return minimum;
    }
}
