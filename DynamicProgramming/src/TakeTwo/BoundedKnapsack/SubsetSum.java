package TakeTwo.BoundedKnapsack;

public class SubsetSum {

    public static void main(String[] args) {
        int[] nums = {2,3,7,8,10};
        int[] targets = {11,13,25,27,29,101,30};

        for(int target: targets) {
            System.out.println("The subset with sum " + target + " is " + ((findSubsetSum(nums, target)) ? "Present" : "Not Present"));
        }
    }

    public static boolean findSubsetSum(int[] nums, int target){
        boolean[][] storage = new boolean[nums.length + 1][target + 1];

        for(int i = 0; i < nums.length + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (i == 0 && j == 0) {
                    storage[i][j] = true;
                }else if (i == 0) {
                    storage[i][j] = false;
                }else if (j == 0) {
                    storage[i][j] = true;
                }
            }
        }
        for(int i = 1; i < nums.length + 1; i++){
            for(int j = 1; j < target + 1; j++){
                if(nums[i - 1] <= j){
                    storage[i][j] = storage[i - 1][j - nums[i - 1]] || storage[i - 1][j];
                }else{
                    storage[i][j] = storage[i - 1][j];
                }
            }
        }
        return storage[nums.length][target];
    }
}
