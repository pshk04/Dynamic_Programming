public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s1 = "agbcba";
        String s2 = new StringBuilder(s1).reverse().toString();
        System.out.println("The total number of insertions and deletions required is: " + findLongestPalindromicSubstring(s1, s2, s1.length(), s2.length()));
    }

    public static int findLongestPalindromicSubstring(String s1, String s2, int n, int m){

        int[][] dp = new int[n + 1][m + 1];
        int maxLength = 0;

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
                    maxLength = Math.max(maxLength, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return maxLength;
    }

}
