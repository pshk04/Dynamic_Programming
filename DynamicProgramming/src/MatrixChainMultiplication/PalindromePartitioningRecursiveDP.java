package MatrixChainMultiplication;

import java.util.Arrays;

public class PalindromePartitioningRecursiveDP {
    public static int[][] dp;
//    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String s = "mamp";
        int start = 0, end = s.length();
        dp = new int[end + 1][end + 1];

        for(int i = 0 ; i < end + 1; i++){
            for(int j = 0; j < end + 1; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println("The minimum number of partitions that makes each palindrome is: "+findMinimumNumberOfPartitioningDP(s, start, end - 1));
        for(int[] row: dp){
            System.out.println(Arrays.toString(row));
        }
    }
    public static int findMinimumNumberOfPartitioningDP(String s, int start, int end){

        System.out.println(start+" : "+end);

        if(start >= end){
            dp[start][end] = 0;
            return 0;
        }

        if(dp[start][end] != -1){
            return dp[start][end];
        }

        if(isPalindrome(s,start,end)){
            dp[start][end] = 0;
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int k = start; k <= end - 1; k++){
            int temp = 1 + findMinimumNumberOfPartitioningDP(s, start, k) + findMinimumNumberOfPartitioningDP(s, k + 1, end);
            min = Math.min(temp, min);
        }

        dp[start][end] = min;
        return min;
    }

    public static boolean isPalindrome(String s, int i, int j){

        if(j < s.length()) {
            while (i <= j) {
//            System.out.println(s.substring(i, j));
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
            return true;
        }else{
            return false;
        }
    }

}
