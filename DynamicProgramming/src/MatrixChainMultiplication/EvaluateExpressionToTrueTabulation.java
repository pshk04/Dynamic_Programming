package MatrixChainMultiplication;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpressionToTrueTabulation{

    public static int[][] dp;

    public static void main(String[] args) {
        String expression = "T|F&T^F";
        int[][] dp = new int[expression.length() + 1][expression.length() + 1];

        for(int i = 0 ; i < expression.length(); i++){
            for(int j = 0 ; j < expression.length(); j++){
                dp[i][j] = -1;
            }
        }
        System.out.println("The total number of expressions that can be formed is: "+findMinimumNumberOfExpressionTabulation(expression, 0, expression.length(), true));
    }

    public static int findMinimumNumberOfExpressionTabulation(String exp, int i, int j, boolean isTrue){

        int ans = 0;
        Map<String, Integer> expMap = new HashMap<>();

        if(i > j){
            return 0;
        }
        if(i == j){
            if(isTrue){
                return (exp.charAt(i) == 'T') ? 1 : 0;
            }else{
                return (exp.charAt(i) == 'F') ? 1 : 0;
            }
        }

        if(expMap.containsKey(i+"_"+j+"_"+((isTrue == true) ? 1 : 0))){
            return expMap.get(i+"_"+j+"_"+((isTrue == true) ? 1 : 0));
        }


        for(int k = i + 1; k <= j - 1; k += 2){
            int leftTrue = findMinimumNumberOfExpressionTabulation(exp, i, k - 1, true);
            int leftFalse = findMinimumNumberOfExpressionTabulation(exp, i, k - 1, false);
            int rightTrue = findMinimumNumberOfExpressionTabulation(exp, i, k - 1, true);
            int rightFalse = findMinimumNumberOfExpressionTabulation(exp, i, k - 1, false);

            if(exp.charAt(k) == '&'){
                if(isTrue) {
                    ans += leftTrue * rightTrue;
                }
            }else if(exp.charAt(k) == '|'){
                if(isTrue) {
                    ans += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                }else{
                    ans += leftFalse * rightFalse;
                }
            }else if(exp.charAt(k) == '^'){
                if(isTrue){
                    ans += leftFalse * rightTrue + leftTrue * rightFalse;
                }else{
                    ans += leftTrue * rightTrue + leftFalse * rightTrue;
                }
            }
        }
        return ans;
    }
}
