package MatrixChainMultiplication;

import java.util.Arrays;

public class MinimumCostForMatrixMultiplication {
    public static int[] nums = {40,20,30,10,30};
    public static int begin = 0, end = nums.length;

    public static int[][] dp = new int[nums.length][nums.length];

    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i][j] = -1;
            }
        }

//        System.out.println("The minimum cost of matrix multiplication is: "+findMinimumCostOfMatrixMultiplication(nums, begin, end));
        System.out.println("The minimum cost of matrix multiplication using memoization is: "
                +findMinimumCostOfMatrixMultiplicationMemoization(nums, 1, end - 1));

        for(int[] row : dp){
            System.out.println(Arrays.toString(row));
        }
    }

    public static int findMinimumCostOfMatrixMultiplicationMemoization(int[] nums, int begin, int end) {

        if (begin >= end) {
            return 0;
        }
        if (dp[begin][end] != -1) {
            return dp[begin][end];
        }

        for (int k = begin; k < end; k++) {
            dp[begin][end] = findMinimumCostOfMatrixMultiplicationMemoization(nums, begin, k)
                    +
                    findMinimumCostOfMatrixMultiplicationMemoization(nums, k + 1, end)
                    +
                    (nums[begin - 1] * nums[k] * nums[end]);
        }

//        System.out.println("here 2: "+dp[begin][end]);

        if (dp[begin][end] < min) {
            min = dp[begin][end];
        }


        return min;
    }

    public static int findMinimumCostOfMatrixMultiplication(int[] nums, int begin, int end) {
        int min = Integer.MAX_VALUE, temp = 0;

        if (begin >= end) {
            return 0;
        }

        for (int k = begin; k < end - 1; k++) {
            temp = findMinimumCostOfMatrixMultiplication(nums, begin, k)
                    +
                    findMinimumCostOfMatrixMultiplication(nums, k + 1, end)
                    +
                    (nums[begin - 1] * nums[k] * nums[end]);
        }

        if (temp < min) {
            min = temp;
        }

        return min;

    }

}
