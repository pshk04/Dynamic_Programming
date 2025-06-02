import java.util.Arrays;

public class EqualSumPartition {

    public static void main(String[] args) {
        int[] nums = {2,3,5,2,2};
        int sum = 7;
        System.out.println("Is it possible to partition the array in to two subsets: "+isEqualSumPartition(nums, sum, nums.length));
    }

    public static boolean isEqualSumPartition(int[] nums, int target, int len){
        int sum = 0;

        for(int i = 0 ; i < len; i++){
            sum += nums[i];
        }

        if(sum % 2 == 0){
            target = sum / 2;
            boolean[][] dp = new boolean[nums.length + 1][target + 1];
            for(int i = 0; i < nums.length + 1; i++) {
                for (int j = 0; j < target + 1; j++) {
                    if (i == 0) {
                        dp[i][j] = false;
                    }
                    if (j == 0) {
                        dp[i][j] = true;
                    }
                }
            }

            for(int i = 1; i < nums.length + 1; i++){
                for(int j = 1; j < target + 1; j++){
                    if(nums[i - 1] <= j){
                        dp[i][j] = dp[i][j - nums[i - 1]] || dp[i - 1][j];
                    }else{
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            for(boolean[] arr : dp){
                System.out.println(Arrays.toString(arr));
            }

            return dp[nums.length][target];
        }
        return false;
    }
}
