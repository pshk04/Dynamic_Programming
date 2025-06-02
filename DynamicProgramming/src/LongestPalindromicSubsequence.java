public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s1 = "agbcba";
        String s2 = new StringBuilder(s1).reverse().toString();
        System.out.println("The total number of insertions and deletions required is: "+findLongestPalindromicSubsequence(s1,s2,s1.length(),s2.length()));
    }

    public static String findLongestPalindromicSubsequence(String s1, String s2, int n, int m){
        int[][] dp = new int[n + 1][m + 1];
        StringBuilder sb = new StringBuilder();

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

        int i = n, j = m;

        while(i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            }else{
                if(dp[i - 1][j] > dp[i][j - 1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        return sb.reverse().toString();
    }
}
