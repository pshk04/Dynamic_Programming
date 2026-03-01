package TakeTwo.LongestCommonSubsequence;

import java.util.ArrayList;
import java.util.List;

public class PrintLongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s1 = "agbcba", s2 = new StringBuilder(s1).reverse().toString();
        int n = s1.length(), m = s2.length();
        System.out.println("The longest palindromic subsequence is: "+printLongestPalindromicSubsequence(s1,s2,n,m));
    }

    public static String printLongestPalindromicSubsequence(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return "";
        }

        int[][] storage = new int[n + 1][m + 1];
        StringBuilder sb = new StringBuilder();
        List<Integer> parsedIndexForS1 = new ArrayList<>();
        List<Integer> parsedIndexForS2 = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    storage[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    storage[i][j] = 1 + storage[i - 1][j - 1];
                } else {
                    storage[i][j] = Math.max(storage[i - 1][j], storage[i][j - 1]);
                }
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(storage[i][j] + " ");
            }
            System.out.println();
        }

        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                if(!parsedIndexForS1.contains(i - 1) && !parsedIndexForS2.contains(j - 1)) {
                    sb.append(s1.charAt(i - 1));
                    parsedIndexForS1.add(i - 1);
                    parsedIndexForS2.add(j - 1);
                }
                i--;
                j--;
            } else {
                if (storage[i][j - 1] > storage[i - 1][j]) {
                    j--;
                    if(!parsedIndexForS2.contains(j - 1)) {
                        sb.append(s2.charAt(j - 1));
                        parsedIndexForS2.add(j - 1);
                    }
                } else if (storage[i - 1][j] >= storage[i][j - 1])  {
                    i--;
                    if(!parsedIndexForS1.contains(i - 1)) {
                        sb.append(s1.charAt(i - 1));
                        parsedIndexForS1.add(i - 1);
                    }
                }
            }
        }
        while(j > 0){
            if(!parsedIndexForS2.contains(j - 1)) {
                sb.append(s2.charAt(j - 1));
                parsedIndexForS2.add(j - 1);
            }
            j--;
        }
        while(i > 0){
            if(!parsedIndexForS1.contains(i - 1)) {
                sb.append(s1.charAt(i - 1));
                parsedIndexForS1.add(i - 1);
            }
            i--;
        }
        return sb.reverse().toString();
    }
}
