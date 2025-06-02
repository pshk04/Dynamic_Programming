import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PrintLongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abde";
        String s2 = "abceh";

        System.out.println("The longest common subsequence using memoization is: "+printLongestCommonSubstringBottomUpDP(s1,s2,s1.length(),s2.length()));
    }

    public static String printLongestCommonSubstringBottomUpDP(String str1, String str2, int n, int m) { // abdh, abceh

        int[][] dp = new int[n + 1][m + 1];
        StringBuilder sb = new StringBuilder();
        String maxLengthCommonSubString = "", commonSubString = "";
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

                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                }else{
                    dp[i][j] = 0;
                }
            }
        }


        return maxLengthCommonSubString;
    }
}
