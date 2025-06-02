import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(Arrays.asList("cat", "sand", "dog"));
        System.out.println(wordBreak("catsanddog", wordDict));
    }

    public static List<String> wordBreak(String s, List<String> wordDict){
        List<List<String>> dp = new ArrayList<>(s.length() + 1);

        for(int i = 0 ; i <= s.length(); i++){
            dp.add(new ArrayList<>());
        }

        dp.get(0).add("");

        for(int i = 1; i <= s.length(); i++){
            String prefix = s.substring(0, i);
            List<String> temp = new ArrayList<>();
            for(int j = 0 ; j < i; j++){
                String suffix = prefix.substring(j);
                if(wordDict.contains(suffix)){
                    for(String substring : dp.get(j)){
                        temp.add(substring + (substring.isEmpty() ? "" : " ") + suffix);
                    }
                }
            }
            dp.set(i, temp);
        }

        return dp.get(s.length());
    }
}
