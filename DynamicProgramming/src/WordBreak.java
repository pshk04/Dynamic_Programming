import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
//        List<String> s = new ArrayList<>(Arrays.asList(
//                "vegancookbook", "catsanddog", "highwaycrash",
//                "pineapplepenapple", "screamicecream", "educativecourse"
//        ));
//
//        List<String> wordDict = new ArrayList<>(Arrays.asList(
//                "ncoo", "kboo", "inea", "icec", "ghway", "and", "anco", "hi", "way", "wa",
//                "amic", "ed", "cecre", "ena", "tsa", "ami", "lepen", "highway", "ples",
//                "ookb", "epe", "nea", "cra", "lepe", "ycras", "dog", "nddo", "hway",
//                "ecrea", "apple", "shp", "kbo", "yc", "cat", "tsan", "ganco", "lescr",
//                "ep", "penapple", "pine", "book", "cats", "andd", "vegan", "cookbook"
//        ));
//        for(int i = 0; i < s.size(); i++) {
//            System.out.println("Is it possible to segment " + s + " in to different dictionary words: " + (wordSegment(s.get(i), wordDict) == true ? "YES" : "NO"));
//        }
        List<String> wordDict = new ArrayList<>(Arrays.asList("cat", "and", "cats", "sand", "dog"));
        System.out.println(wordSegment("catsandog", wordDict));
        System.out.println(wordSegment("catsanddog", wordDict));
    }

    /**
     * Time Complexity: O(n*n*n + (w * l))
     * Space Complexity: O(n) which is lookup table space.
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordSegment(String s, List<String> wordDict){

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0]= true;
        Set<String> wordDictSet = new HashSet<>(wordDict);

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
