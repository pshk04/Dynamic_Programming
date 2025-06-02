import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {

    public static void main(String[] args) {
        int[][] numsArray = {
                {2,3,4}
        };
        int[] target = {6};

        for(int i = 0; i < numsArray.length; i++) {
            System.out.println("The possible sub array combinations with target sum are: " + combinationsSum(numsArray[i], target[i]));
            System.out.println("Is there a possible sub array combinations with given target: " + combinationsSumBoolean(numsArray[i], target[i]));
        }
    }

    public static boolean combinationsSumBoolean(int[] nums, int target){
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        for(int i = 0; i < nums.length + 1; i++){
            for(int j = 0; j < target + 1; j++){
                if(i == 0){
                    dp[i][j] = false;
                }
                if(j == 0){
                    dp[i][j] = true;
                }
            }
        }
        for(int i = 1; i < nums.length + 1; i++){
            for(int j = 1; j < target + 1; j++){
                if(nums[i - 1] <= j){
                    dp[i][j] = dp[i][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];

    }
    public static List<List<Integer>> combinationsSum(int[] nums, int target){

        List<List<List<Integer>>> dp = new ArrayList<>(target + 1);
        dp.add(new ArrayList<>());
        dp.get(0).add(new ArrayList<>());

        for(int i = 1; i <= target; i++){
            dp.add(new ArrayList<>());
            for(int j = 0 ; j < nums.length; j++){
                if(nums[j] <= i){
                    for(List<Integer> prev : dp.get(i - nums[j])){
                        List<Integer> temp = new ArrayList<>(prev);
                        temp.add(nums[j]);
                        Collections.sort(temp); // O(slog(s))

                        if(!dp.get(i).contains(temp)){
                            dp.get(i).add(temp);
                        }
                    }
                }
            }
        }
        return dp.get(target);
    }
}
