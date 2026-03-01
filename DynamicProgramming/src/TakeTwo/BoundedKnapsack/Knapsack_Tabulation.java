package TakeTwo.BoundedKnapsack;

public class Knapsack_Tabulation {
    static int[][] storage;
    public static void main(String[] args) {
        int[] weights = {4,4,6,8};
        int[] values = {2,4,4,5};
        int capacity = 15, n = weights.length;
        storage = new int[n + 1][capacity + 1];

        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < capacity + 1; j++){
                storage[i][j] = 0;
            }
        }

        System.out.println("The knapsack with max capacity is: "+findMaxValue(capacity, weights, values, n));
    }

    public static int findMaxValue(int capacity, int[] weights, int[] values, int n){

        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < capacity + 1; j++){
                if(i == 0 || j == 0) {
                    storage[i][j] = 0;
                }else{
                    if (weights[i - 1] <= j) {
                        storage[i][j] =  Math.max((values[i - 1] + storage[i - 1][j - weights[i - 1]]), storage[i - 1][j]);
                    } else{
                        storage[i][j] =  storage[i - 1][j];
                    }
                }
            }
        }


        return storage[n][capacity];

    }
}
