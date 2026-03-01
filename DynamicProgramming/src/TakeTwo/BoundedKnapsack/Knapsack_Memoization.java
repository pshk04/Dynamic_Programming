package TakeTwo.BoundedKnapsack;

public class Knapsack_Memoization {
    static int[][] storage;

    public static void main(String[] args) {
        int[] weights = {1,3,4,5};
        int[] values = {1,4,5,7};
        int capacity = 7, n = weights.length;
        storage = new int[n + 1][capacity + 1];

        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < capacity + 1; j++){
                storage[i][j] = -1;
            }
        }

        System.out.println("The knapsack with max capacity is: "+findMaxValue(capacity, weights, values, n));
    }

    public static int findMaxValue(int capacity, int[] weights, int[] values, int n){

        if(capacity == 0 || n == 0){
            return 0;
        }
        if(storage[n - 1][capacity] != -1){
            return storage[n - 1][capacity];
        }else {
            if (weights[n - 1] <= capacity) {
                storage[n][capacity] =  Math.max(values[n - 1] + findMaxValue(capacity - weights[n - 1], weights, values, n - 1),
                        findMaxValue(capacity, weights, values, n - 1));
            } else if (weights[n - 1] > capacity) {
                storage[n][capacity] =  findMaxValue(capacity, weights, values, n - 1);
            }
        }

        return storage[n][capacity];

    }
}
