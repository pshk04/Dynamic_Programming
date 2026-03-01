package TakeTwo.BoundedKnapsack;

public class EqualSumPartition {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5,3,3};
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        System.out.println("Can we divide this array in to 2 subsets with equal sum? "+((findEqualSumPossibility(nums,sum)) ? "Yes" : "No"));
    }

    public static boolean findEqualSumPossibility(int[] nums, int target) {
        if(target % 2 != 0){
            return false;
        }else {
            boolean[][] storage = new boolean[nums.length + 1][target + 1];

            for (int i = 0; i < nums.length + 1; i++) {
                for (int j = 0; j < target + 1; j++) {
                    if (i == 0 && j == 0) {
                        storage[i][j] = true;
                    } else if (j == 0) {
                        storage[i][j] = true;
                    } else if (i == 0) {
                        storage[i][j] = false;
                    }
                }
            }

            for (int i = 1; i < nums.length + 1; i++) {
                for (int j = 1; j < target + 1; j++) {
                    if (nums[i - 1] <= j) {
                        storage[i][j] = storage[i - 1][j - nums[i - 1]] || storage[i - 1][j];
                    } else {
                        storage[i][j] = storage[i - 1][j];
                    }

                }
            }
            return storage[nums.length][target];
        }
    }
}
