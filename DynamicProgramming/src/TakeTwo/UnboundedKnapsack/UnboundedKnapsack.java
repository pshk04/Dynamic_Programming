package TakeTwo.UnboundedKnapsack;

public class UnboundedKnapsack {
    static int[][] storage;
    public static void main(String[] args) {
        int[] weights = {4,4,6,8};
        int[] values = {2,4,4,5};
        int capacity = 15, n = weights.length;
        storage = new int[n + 1][capacity + 1];

        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < capacity + 1; j++){
                if(i == 0) {
                    storage[i][j] = 0;
                }
                if(i == 0 && j == 0){
                    storage[i][j] = 1;
                }else if(j == 0){
                    storage[i][j] = 1;
                }
            }
        }

        System.out.println("The knapsack with max capacity is: "+findMaxValueForUnBoundedKnapsack(capacity, weights, values, n));
    }

    public static int findMaxValueForUnBoundedKnapsack(int capacity, int[] weights, int[] values, int n){

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < capacity + 1; j++){
                if (weights[i - 1] <= j) {
                    storage[i][j] =  Math.max((values[i - 1] + storage[i][j - weights[i - 1]]), storage[i - 1][j]);
                } else{
                    storage[i][j] =  storage[i - 1][j];
                }
            }
        }
        for(int i = 0 ; i < n + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                System.out.print(storage[i][j] + " ");
            }
            System.out.println();
        }

        return storage[n][capacity];
    }
}
