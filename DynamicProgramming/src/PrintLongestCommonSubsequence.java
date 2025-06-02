public class PrintLongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "abcdaf";
        String s2 = "acbcf";

        System.out.println("The longest common subsequence using memoization is: "+printLongestCommonSubsequenceBottomUpDP(s1,s2,s1.length(),s2.length()));
    }

    public static String printLongestCommonSubsequenceBottomUpDP(String str1, String str2, int n, int m) { // abdh, abceh

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
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = n , j = m;
        while(i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            }else{
                if(dp[i][j-1] > dp[i-1][j]){
                    j--;
                }else{
                    i--;
                }
            }
        }
        return sb.reverse().toString();
    }
}
