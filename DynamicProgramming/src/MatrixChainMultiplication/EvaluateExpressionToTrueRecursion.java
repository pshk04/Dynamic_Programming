package MatrixChainMultiplication;

public class EvaluateExpressionToTrueRecursion {

    public static void main(String[] args) {
        String expression = "T|F&T^F";
        System.out.println("The total number of expressions that can be formed is: "+findMinimumNumberOfExpression(expression, 0, expression.length(), true));
    }

    public static int findMinimumNumberOfExpression(String exp, int i, int j, boolean isTrue){
        int ans = 0;

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

        for(int k = i + 1; k <= j - 1; k += 2){
            int leftTrue = findMinimumNumberOfExpression(exp, i, k - 1, true);
            int leftFalse = findMinimumNumberOfExpression(exp, i, k - 1, false);
            int rightTrue = findMinimumNumberOfExpression(exp, i, k - 1, true);
            int rightFalse = findMinimumNumberOfExpression(exp, i, k - 1, false);

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
