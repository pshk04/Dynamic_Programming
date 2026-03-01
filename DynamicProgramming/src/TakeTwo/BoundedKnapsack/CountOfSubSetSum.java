package TakeTwo.BoundedKnapsack;

public class CountOfSubSetSum {
    public static void main(String[] args) {
        int[] nums = {2,3,5,6,8,10};
        int target = 10;
        System.out.println("Total number of subset sums for a given target: "+findTotalNoOfSubsetSum(nums, target));
    }

    public static int findTotalNoOfSubsetSum(int[] nums, int target) {
        int[][] storage = new int[nums.length + 1][target + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (i == 0 && j == 0) {
                    storage[i][j] = 1;
                } else if (j == 0) {
                    storage[i][j] = 1;
                } else if (i == 0) {
                    storage[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (nums[i - 1] <= j) {
                    storage[i][j] = storage[i - 1][j - nums[i - 1]] + storage[i - 1][j];
                } else {
                    storage[i][j] = storage[i - 1][j];
                }

            }
        }
        return storage[nums.length][target];
    }
}
