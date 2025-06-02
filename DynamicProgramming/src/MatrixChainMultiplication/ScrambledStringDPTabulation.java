package MatrixChainMultiplication;

import java.util.HashMap;
import java.util.Map;

public class ScrambledStringDPTabulation {
    public static Map<String, Boolean> scrambledStrMap;

    public static void main(String[] args) {
        String s1 = "great", s2 = "tgrae";
        scrambledStrMap = new HashMap<>();
        System.out.println("Are the given strings scrambled? "+areGivenStringsScrambled(s1, s2));
    }

    public static boolean areGivenStringsScrambled(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() <= 1 || s2.length() <= 1) {
            return false;
        }

        if(scrambledStrMap.containsKey(s1+"_"+s2)){
            return scrambledStrMap.get(s1+"_"+s2);
        }

        boolean isScrambled = false;
        int n = s1.length();

        for(int i = 1; i <= n - 1; i++){
            if((areGivenStringsScrambled(s1.substring(0, i), s2.substring(n - i, n - i + i))
                    &&
                    areGivenStringsScrambled(s1.substring(i, n - i + i), s2.substring(0, n - i)))
                    ||
                    (areGivenStringsScrambled(s1.substring(0, i), s2.substring(0, i))
                            &&
                            areGivenStringsScrambled(s1.substring(i, n - i + i), s2.substring(i, n - i + i))))
            {
                isScrambled = true;
            }
        }
        scrambledStrMap.put(s1+"_"+s2, isScrambled);
        return isScrambled;
    }
}
