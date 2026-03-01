package TakeTwo.BoundedKnapsack;

public class MinimumSubsetSumDifference {

    public static void main(String[] args) {
        int[] nums = {1,6,11,5,6};
        System.out.println("The minimum difference between 2 subset sums is: "+findMinimumSubSetSumDifference(nums));
    }

    public static int findMinimumSubSetSumDifference(int[] nums){

        int range = 0, minimum = Integer.MAX_VALUE, element = 0;

        for(int i = 0; i < nums.length; i++){
            range += nums[i];
        }
        System.out.println("The range: "+range);

        boolean[][] storage = new boolean[nums.length + 1][range + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            for (int j = 0; j < range + 1; j++) {
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
            for (int j = 1; j < range + 1; j++) {
                if (nums[i - 1] <= j) {
                    storage[i][j] = storage[i - 1][j - nums[i - 1]] || storage[i - 1][j];
                } else {
                    storage[i][j] = storage[i - 1][j];
                }

            }
        }

        for (int i = nums.length; i < nums.length + 1; i++) {
            for (int j = 1; j <= (range / 2); j++) {
                System.out.print(storage[i][j] +" ");
            }
            System.out.println();
        }

        for(int k = 1; k <= (range / 2); k++){
            if(storage[nums.length][k]) {
                minimum = Math.min(minimum, (range - (2 * k)));
                System.out.println("minimum: " + minimum + " k: " + k);
            }
        }
        return minimum;
    }
}
