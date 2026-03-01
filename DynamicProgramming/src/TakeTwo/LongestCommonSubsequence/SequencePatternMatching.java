package TakeTwo.LongestCommonSubsequence;

public class SequencePatternMatching {
    public static void main(String[] args) {
        String s1 = "axy", s2 = "abxcpy"; // LCS is 4 i.e., "abdh"

        System.out.println("Does "+s2.toString()+" present in "+s1.toString()+": "+
                ((findSequencePatternMatching(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length())) ? "Yes" : "No"));

    }

    public static boolean findSequencePatternMatching(char[] s1, char[] s2, int n, int m){
        if(n == 0 || m == 0){
            return false;
        }

        int[][] storage = new int[s1.length + 1][s2.length + 1];

        for(int i = 0 ; i < s1.length + 1; i++){
            for(int j = 0; j < s2.length + 1 ; j++){
                if(i == 0 || j == 0) {
                    storage[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(s1[i - 1] == s2[j - 1]){
                    storage[i][j] = 1 + storage[i - 1][j - 1];
                }else{
                    storage[i][j] = Math.max(storage[i - 1][j], storage[i][j - 1]);
                }
            }
        }

        for(int i = 0 ; i < s1.length + 1; i++){
            for(int j = 0; j < s2.length + 1; j++){
                System.out.print(storage[i][j] + " ");
            }
            System.out.println();
        }
        return (s1.length == storage[n][m]);
    }
}
