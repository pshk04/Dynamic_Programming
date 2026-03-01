package TakeTwo.LongestCommonSubsequence;

public class PrintLongestCommonSubsequenceTabulation {
    public static void main(String[] args) {
        char[] s1 = "aaabc".toCharArray();
        char[] s2 = "aabc".toCharArray(); // LCS is 4 i.e., "abdh"

        System.out.println("The longest common subsequence is: "+findLongestCommonSubsequence(s1, s2, s1.length, s2.length) + "\n");

    }

    public static String findLongestCommonSubsequence(char[] s1, char[] s2, int n, int m){
        if(n == 0 || m == 0){
            return "";
        }

        int[][] storage = new int[s1.length + 1][s2.length + 1];
        StringBuilder sb = new StringBuilder();

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
        int i = n , j = m;
        while(i > 0 && j > 0){
            if(s1[i - 1] == s2[j - 1]){
                sb.append(s1[i - 1]);
                i--;
                j--;
            }else{
                if(storage[i][j-1] > storage[i-1][j]){
                    sb.append(s2[j - 1]);
                    j--;
                }else{
                    sb.append(s1[i - 1]);
                    i--;
                }
            }
        }
        return sb.reverse().toString();
    }
}
