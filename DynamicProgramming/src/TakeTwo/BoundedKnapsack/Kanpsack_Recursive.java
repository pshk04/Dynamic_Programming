package TakeTwo.BoundedKnapsack;

public class Kanpsack_Recursive {

    public static void main(String[] args) {
        int[] weights = {1,3,4,5};
        int[] values = {1,4,5,7};
        int capacity = 7, totalItems = weights.length;

        System.out.println("The knapsack with max capacity is: "+findMaxValue(capacity, weights, values, totalItems));
    }

    public static int findMaxValue(int capacity, int[] weights, int[] values, int n){

        if(capacity == 0 || n == 0){
            return 0;
        }

        if(weights[n - 1] <= capacity){
            return Math.max(values[n - 1] + findMaxValue(capacity - weights[n - 1], weights, values, n - 1),
                    findMaxValue(capacity, weights, values, n - 1));
        }else if (weights[n - 1] > capacity){
            return findMaxValue(capacity, weights, values, n - 1);
        }

        return 0;

    }
}
