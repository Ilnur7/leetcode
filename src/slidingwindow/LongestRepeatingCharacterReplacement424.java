package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement424 {
    public static void main(String[] args) {
        int count = characterReplacement("AABABBA", 1);
        System.out.println(count);
    }

    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            Integer count = map.getOrDefault(s.charAt(right), 0);
            //if (count )
        }
        return 0;
    }
}
