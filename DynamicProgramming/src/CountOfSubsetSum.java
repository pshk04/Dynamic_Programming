import java.util.Arrays;

public class CountOfSubsetSum {

    public static void main(String[] args) {
        int[] nums = {2,3,5,6,8,10};
        int target = 10;
        System.out.println("The count of subset sum to target is: "+countOfSubsetsToSum(nums, target));
    }

    public static int countOfSubsetsToSum(int[] nums, int target){
        int[][] dp = new int[nums.length + 1][target + 1];

        for(int i = 0; i < nums.length + 1; i++){
            for(int j = 0; j < target + 1; j++){
                if(i == 0){
                    dp[i][j] = 0;
                }
                if(j == 0){
                    dp[i][j] = 1;
                }
            }
        }
        for(int i = 1; i < nums.length + 1; i++){
            for(int j = 1; j < target + 1; j++){
                if(nums[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for(int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }

        return dp[nums.length][target];
    }
}
