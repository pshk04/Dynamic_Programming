public class CountPalindromicSubstrings {

    public static void main(String[] args) {
        String[] sArray = {"peeweep", "mnm", "rotator", "racecar" };
//        for(String s : sArray) {
//            System.out.println("The total number of palindromic substrings are: " + countPalindromicSubstrings(s));
//        }
        System.out.println("The total number of palindromic substrings are: " + countPalindromicSubstrings("peeweep"));
    }

    public static int countPalindromicSubstrings(String s){
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i = 0 ; i < s.length(); i++){
            dp[i][i] = true;
            count++;
            System.out.println(i+" "+i+" "+dp[i][i] +" : "+count);
        }

        for(int i = 0; i < s.length() - 1; i++){
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            count += dp[i][i + 1] ? 1 : 0;
            System.out.println(i+" "+(i + 1)+" "+dp[i][i + 1] +" : "+count);
        }

        System.out.println("--------------------------------------");

        for(int length = 3; length <= s.length(); length++){
            for(int i = 0, j = length - 1; j < s.length(); i++,j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                count += dp[i][j] ? 1 : 0;
                System.out.println(i+" "+j+" "+dp[i][j] +" : "+count);
            }
        }

        return count;
    }
}
