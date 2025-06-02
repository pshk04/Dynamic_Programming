import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        int[][] moneyArrays = {
                {1,2,10,2},
                {7,4,9,1,3}
        };
        for(int[] money: moneyArrays) {
            System.out.println("The maximum rob value is: " + houseRobber(money));
        }
    }

    public static int houseRobber(int[] money){

        return Math.max(houseRobberHelper(Arrays.copyOfRange(money, 0, money.length - 1)),
                houseRobberHelper(Arrays.copyOfRange(money, 0, money.length - 1))
        );
    }

    public static int houseRobberHelper(int[] money){

        int[] lookUpArray = new int[money.length + 1];
        lookUpArray[0] = 0;
        lookUpArray[1] = money[0];

        for(int i = 2; i <= money.length; i++){
            lookUpArray[i] = Math.max((money[i - 1] + lookUpArray[i - 2]), lookUpArray[i - 1]);
        }

        return lookUpArray[money.length];
    }
}
