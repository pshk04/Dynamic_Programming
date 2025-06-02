import java.util.Arrays;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "abdh";
        String s2 = "abceh";

        System.out.println("The longest common subsequence using memoization is: "+longestCommonSubstringBottomUpDP(s1,s2,s1.length(),s2.length()));
    }

    public static int longestCommonSubstringBottomUpDP(String str1, String str2, int n, int m) { // abdh, abceh

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
//                System.out.println("i: "+i+" j: "+j+" : "+(str1.charAt(i - 1) == str2.charAt(j - 1)));

                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
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
