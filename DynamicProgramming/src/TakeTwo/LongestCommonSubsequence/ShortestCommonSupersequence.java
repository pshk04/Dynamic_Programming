package TakeTwo.LongestCommonSubsequence;

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String a = "geek", b = "eke";
        System.out.println("The shortest common supersequence is : "+findShortestCommonSupersequence(a, b, a.length(), b.length()));
        // (a.length() + b.length() - LCS(s1, s2)
    }

    public static int findShortestCommonSupersequence(String s1, String s2, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }

        int[][] storage = new int[n + 1][m + 1];

        for(int i = 0 ; i < n + 1; i++){
            for(int j = 0; j < m + 1 ; j++){
                if(i == 0 || j == 0) {
                    storage[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    storage[i][j] = 1 + storage[i - 1][j - 1];
                }else{
                    storage[i][j] = Math.max(storage[i - 1][j], storage[i][j - 1]);
                }
            }
        }

        for(int i = 0 ; i < n + 1; i++){
            for(int j = 0; j < m + 1; j++){
                System.out.print(storage[i][j] + " ");
            }
            System.out.println();
        }
        return (n + m) - storage[n][m];
    }
}
