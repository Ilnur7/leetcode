package slidingwindow;

import java.util.Set;

public class MaximumNumberVowelsSubstringGivenLength1456 {
    public static void main(String[] args) {

    }

    public static int maxVowels(String s, int k) {
        int left = 0;
        int maxVowels = 0;
        int windowState = 0;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

        for (int right = 0; right < s.length(); right++) {
            if (set.contains(s.charAt(right))) {
                windowState++;
                maxVowels = Math.max(maxVowels, windowState);
            }
            if (right - left + 1 >= k) {
                if (set.contains(s.charAt(left))) {
                    windowState--;
                }
                left++;
            }

            if (maxVowels == k) {
                return k;
            }
        }

        return maxVowels;
    }
}
