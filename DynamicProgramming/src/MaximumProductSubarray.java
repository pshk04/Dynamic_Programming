import java.util.Arrays;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[][] numsArray = {
                {2,-5,3,1,-4,0,-10,2},
                {2,3,-2,4},
                {1,2,3,4}
        };
        for(int[] nums: numsArray) {
            System.out.println("The sub array with max product is: " + maxProductSubArray(nums));
        }
    }

    public static int maxProductSubArray(int[] nums){

        int max = nums[0];
        int min = nums[0];
        int result = max, current = 0, previousMax = 0;

        for(int i = 1; i < nums.length; i++){
            current = nums[i];
            previousMax = max;

            max = Math.max(current, Math.max(max * current, min * current));
            min = Math.min(current, Math.min(max * current, min * current));
            result = Math.max(max, result);

        }
        return result;
    }

    public static int[] maxProductSubArrayUnOptimized(int[] nums){
        int product = 0, maxProduct = 0, start = 0, end = 0;

        for(int i = 0 ; i < nums.length - 1; i++) {
            product = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                product *= nums[j];
                if (product >= maxProduct) {
                    maxProduct = product;
                    start = i;
                    end = j;
//                    System.out.println("Max product: "+maxProduct);
                }
            }
            product = 0;
        }
//        System.out.println("End: "+end);
        return new int[]{start, end + 1};
    }
}
