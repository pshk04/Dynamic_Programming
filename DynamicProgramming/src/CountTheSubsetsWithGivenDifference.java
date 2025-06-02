/**
 * Similar to Targeted Sum problem where an element of an array takes +/- sign before it and a difference of 2 subsets is equal to a given 'diff' value
 */

public class CountTheSubsetsWithGivenDifference {
    public static void main(String[] args) {
        int[][] numsArray = {
                {1,1,2,3},
                {2,2,3,4},
                {4,4,6,9}
        };
        int[] diffsArray = {1,3,3};
        for(int i = 0 ; i < numsArray.length; i++) {
            System.out.println("The number of subsets with difference " + diffsArray[i] + " is: " + findTheCountOfSubsetsWithGivenDifference(numsArray[i], diffsArray[i]));
        }
    }

    public static int findTheCountOfSubsetsWithGivenDifference(int[] nums, int diff){
        int totalSum = 0, targetSum = 0;

        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }

        targetSum = (totalSum + diff) / 2;
        int[][] dp = new int[nums.length + 1][targetSum + 1];

        for(int i = 0; i < nums.length + 1; i++){
            for(int j = 0 ; j < targetSum + 1; j++){
                if(i == 0){
                    dp[i][j] = 0;
                }
                if(j == 0){
                    dp[i][j] = 1;
                }
            }
        }

        for(int i = 1; i < nums.length + 1; i++){
            for(int j = 1; j < targetSum + 1; j++){
                if(nums[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][targetSum];

    }
}
