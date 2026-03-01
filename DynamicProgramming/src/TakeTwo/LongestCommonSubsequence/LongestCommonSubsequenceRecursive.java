package TakeTwo.LongestCommonSubsequence;

public class LongestCommonSubsequenceRecursive {

    public static void main(String[] args) {
        char[] s1 = "abcdgh".toCharArray();
        char[] s2 = "abedfhr".toCharArray(); // LCS is 4 i.e., "abdh"
        System.out.println("The longest common subsequence is: "+findLongestCommonSubsequence(s1, s2, s1.length, s2.length));
    }

    public static int findLongestCommonSubsequence(char[] s1, char[] s2, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }

        if(s1[n - 1] == s2[m -1]){
            return 1 + findLongestCommonSubsequence(s1, s2, n - 1, m - 1);
        }else{
            return Math.max(findLongestCommonSubsequence(s1, s2, n, m - 1),
                    findLongestCommonSubsequence(s1, s2, n - 1, m));
        }
    }
}
