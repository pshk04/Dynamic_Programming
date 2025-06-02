package MatrixChainMultiplication;

public class PalindromePartinioningRecursiveNoDP {

    public static void main(String[] args) {
        String s = "nitik";
        int i = 0, j = s.length() - 1;
        System.out.println("The minimum number of partitions that makes each palindrome is: "+findMinimumNumberOfPartitioning(s, i, j));
    }

    public static int findMinimumNumberOfPartitioning(String s, int i, int j){
        System.out.println(i+" : "+j);
        if(i >= j){
            return 0;
        }

        if(isPalindrome(s,i,j)){
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int k = i; k <= j - 1; k++){
            int temp = 1 + findMinimumNumberOfPartitioning(s, i, k) + findMinimumNumberOfPartitioning(s, k + 1, j);
            if(temp < min){
                min = temp;
            }
        }
        return min;
    }

    public static boolean isPalindrome(String s, int i, int j){

        while(i < j){
//            System.out.println(s.substring(i, j));
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}
