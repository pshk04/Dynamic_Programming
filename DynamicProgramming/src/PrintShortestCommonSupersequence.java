public class PrintShortestCommonSupersequence {

    public static void main(String[] args) {
//        String s1 = "abcdaf";
//        String s2 = "acbcf";

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println("The length of shortest common supersequence using tabulation is: "+printShortestCommonSupersequence(s1,s2,s1.length(),s2.length()));
    }

    public static String printShortestCommonSupersequence(String str1, String str2, int m, int n){

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
                if(str1.charAt(j - 1) == str2.charAt(i - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = n , j = m;
        while(i > 0 && j > 0){
            if(str1.charAt(j - 1) == str2.charAt(i - 1)){
                sb.append(str1.charAt(j - 1));
                i--;
                j--;
            }else{
                if(dp[i][j-1] > dp[i-1][j]){
                    sb.append(str1.charAt(j - 1));
                    j--;
                }else if(dp[i - 1][j] >= dp[i][j - 1]){
                    sb.append(str2.charAt(i - 1));
                    i--;
                }
            }
            System.out.println("i: "+i+" j: "+j+" sb: "+sb.toString());
        }
        while(j > 0){
            sb.append(str1.charAt(j - 1));
            j--;
        }
        while(i > 0){
            sb.append(str2.charAt(i - 1));
            i--;
        }
        return sb.reverse().toString();
    }
}
