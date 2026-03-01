package TakeTwo.MatrixChainMultiplication;

public class MatrixChainMultiplicationRecursive {
    static int minimum = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] nums = {10,30,5,60};
        System.out.println("The minimum cost (multiplication value) of the array is: "+findMinimumCostOfMatrixMultiplication(nums, 1, nums.length - 1));
    }

    public static int findMinimumCostOfMatrixMultiplication(int[] nums, int i, int j){

        if(i >= j){
            return 0;
        }

        for(int k = i; k < j; k++){
            int temp = findMinimumCostOfMatrixMultiplication(nums, i, k) +
                    findMinimumCostOfMatrixMultiplication(nums, k + 1, j) +
                    (nums[i - 1] * nums[k] * nums[j]);
            minimum = Math.min(temp, minimum);

        }
        return minimum;
    }
}
