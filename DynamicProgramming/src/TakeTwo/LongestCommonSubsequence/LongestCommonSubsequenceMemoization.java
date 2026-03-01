package TakeTwo.LongestCommonSubsequence;

public class LongestCommonSubsequenceMemoization {
    static int[][] storage;
    public static void main(String[] args) {
        char[] s1 = "abcdgh".toCharArray();
        char[] s2 = "abedfhr".toCharArray(); // LCS is 4 i.e., "abdh"
        storage = new int[s1.length + 1][s2.length + 1];
        for(int i = 0 ; i < s1.length + 1; i++){
            for(int j = 0; j < s2.length + 1 ; j++){
                storage[i][j] = -1;
            }
        }
        System.out.println("The longest common subsequence is: "+findLongestCommonSubsequence(s1, s2, s1.length, s2.length) + "\n");
        for(int i = 0 ; i < s1.length + 1; i++){
            for(int j = 0; j < s2.length + 1; j++){
                System.out.print(storage[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findLongestCommonSubsequence(char[] s1, char[] s2, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }
        if(storage[n][m] != -1){
            return storage[n][m];
        }else {
            if (s1[n - 1] == s2[m - 1]) {
                storage[n][m] = 1 + findLongestCommonSubsequence(s1, s2, n - 1, m - 1);
            } else {
                storage[n][m] = Math.max(findLongestCommonSubsequence(s1, s2, n, m - 1),
                        findLongestCommonSubsequence(s1, s2, n - 1, m));
            }
        }
        return storage[n][m];
    }
}
