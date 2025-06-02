public class PrintLongestRepeatingSubsequence {

    public static void main(String[] args) {
        String s1 = "ppqrsqsr";
        String s2 = s1;

        System.out.println("The longest repeating subsequence using memoization is: "+longestRepeatingSubsequenceBottomUpDP(s1,s2,s1.length(),s2.length()));
    }

    public static String longestRepeatingSubsequenceBottomUpDP(String s1, String s2, int n, int m){

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0 ; i < n + 1; i++){
            for(int j = 0 ; j < m + 1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1) && i != j){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int i = n, j = m;
        StringBuilder sb = new StringBuilder();

        while(i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1) && (i == j)){
                if(dp[i - 1][j] > dp[i][j - 1]){
                    i--;
                }else{
                    j--;
                }
            }else if(s1.charAt(i - 1) == s2.charAt(j - 1) && (i != j)){
                sb.append(s1.charAt(i - 1));
                if(dp[i - 1][j] < dp[i][j - 1]){
                    j--;
                }else if(dp[i - 1][j] >= dp[i][j - 1]){
                    i--;
                }
            }else{
                if(dp[i - 1][j] < dp[i][j - 1]){
                    j--;
                }else if(dp[i - 1][j] >= dp[i][j - 1]){
                    i--;
                }
            }
        }
//        while(j > 0){
//            sb.append(s1.charAt(j - 1));
//            j--;
//        }
//        while(i > 0){
//            sb.append(s2.charAt(i - 1));
//            i--;
//        }



        return sb.reverse().toString();
    }
}
