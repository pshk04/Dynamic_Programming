import java.util.Arrays;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        String s1 = "abdh";
        String s2 = "abceh";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
//        System.out.println("The longest common subsequence using tabulation is: "+longestCommonSubsequenceRecursiveFront("bed", "read",0,0,dp));
//        System.out.println("The longest common subsequence using memoization is: "+longestCommonSubsequenceRecursiveRear("bed", "read",s1.length(),s2.length()));
//        System.out.println("The longest common subsequence using memoization is: "+longestCommonSubsequenceTopDownDP("bed", "read",s1.length(),s2.length(), dp));
        System.out.println("The longest common subsequence using memoization is: "+longestCommonSubsequenceBottomUpDP(s1,s2,s1.length(),s2.length()));
    }

    public static int longestCommonSubsequenceRecursiveFront(String str1, String str2, int i, int j, int[][] dp) {
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            dp[i][j] = 1 + longestCommonSubsequenceRecursiveFront(str1, str2, i + 1, j + 1, dp);
        } else {
            dp[i][j] = Math.max(longestCommonSubsequenceRecursiveFront(str1, str2, i + 1, j, dp), longestCommonSubsequenceRecursiveFront(str1, str2, i, j + 1, dp));
        }
        return dp[i][j];
    }

    public static int longestCommonSubsequenceRecursiveRear(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if(str1.charAt(n - 1) == str2.charAt(m - 1)){
            return (1 + longestCommonSubsequenceRecursiveRear(str1, str2,n - 1,m - 1));
        }else{
            return Math.max(longestCommonSubsequenceRecursiveRear(str1, str2,n - 1, m), longestCommonSubsequenceRecursiveRear(str1, str2, n, m - 1));
        }
    }

    public static int longestCommonSubsequenceTopDownDP(String str1, String str2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }else {

            if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
                dp[n][m] = (1 + longestCommonSubsequenceTopDownDP(str1, str2, n - 1, m - 1, dp));
            } else {
                dp[n][m] = Math.max(longestCommonSubsequenceTopDownDP(str1, str2, n - 1, m, dp), longestCommonSubsequenceTopDownDP(str1, str2, n, m - 1, dp));
            }

            return dp[n][m];
        }
    }

    public static int longestCommonSubsequenceBottomUpDP(String str1, String str2, int n, int m) { // abdh, abceh

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
//                System.out.println("i: "+i+" j: "+j+" : "+(str1.charAt(i - 1) == str2.charAt(j - 1)));

                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
