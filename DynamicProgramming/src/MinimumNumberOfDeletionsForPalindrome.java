public class MinimumNumberOfDeletionsForPalindrome {
    public static void main(String[] args) {
        String s1 = "agbcba";
        StringBuilder sb = new StringBuilder(s1).reverse();
        String s2 = sb.toString();

        System.out.println("The minimum number of deletions required to make "+s1+" palindrome is "+findMinimumNumberOfDeletionsForPalindrome(s1,s2,s1.length(),s2.length()));
    }

    public static int findMinimumNumberOfDeletionsForPalindrome(String s1, String s2, int n, int m){
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < m + 1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return s1.length() - dp[n][m];
    }
}
