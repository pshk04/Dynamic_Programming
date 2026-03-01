package TakeTwo.MatrixChainMultiplication;

public class MatrixChainMultiplicationMemoization {
    static int[][] storage;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] nums = {10,30,5,60};
        storage = new int[nums.length + 1][nums.length + 1];

        for(int i = 0; i < nums.length + 1; i++){
            for(int j = 0 ; j < nums.length + 1; j++){
                storage[i][j] = -1;
            }
        }
        System.out.println("The minimum cost (multiplication value) of the array is: "+findMinimumCostOfMatrixMultiplication(nums, 1, nums.length - 1));
    }

    public static int findMinimumCostOfMatrixMultiplication(int[] nums, int i, int j){
        if(i >= j){
            return 0;
        }
        if(storage[i][j] != -1){
            return storage[i][j];
        }

        for(int k = i; k < j; k++){
            int temp = findMinimumCostOfMatrixMultiplication(nums, i, k) +
                    findMinimumCostOfMatrixMultiplication(nums, k + 1, j) +
                    (nums[i - 1] * nums[k] * nums[j]);

            min = Math.min(temp, min);
            storage[i][j] = min;

        }

        return storage[i][j];
    }
}
