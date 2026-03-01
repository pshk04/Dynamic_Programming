package TakeTwo.BoundedKnapsack;

public class TargetSumWithSign {

    public static void main(String[] args) {
        int[][] numsArray = {
                {1, 6, 11, 5, 5, 2},
                {1,1,2,3}
        };
        int[] difference = {2,1};

        for(int i = 0; i < numsArray.length; i++) {
            System.out.println("Total number of subsets with given difference are: " +
                    findTotalSubSetsWithTargetSum(numsArray[i], difference[i]));
        }
    }

    public static int findTotalSubSetsWithTargetSum(int[] nums, int difference){
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        int target = (difference + sum) / 2;
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
