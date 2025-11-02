package twoPointers;

public class IsSubsequence392 {
    public static void main(String[] args) {

    }

    public boolean isSubsequence1(String substr, String s) {
        int i = 0; // Index for substr
        int j = 0; // Index for s

        while (i < substr.length() && j < s.length()) {
            // If the current characters match, move to the next character in substr
            if (substr.charAt(i) == s.charAt(j)) {
                i++;
            }
            // Move to the next character in s regardless
            j++;
        }

        // If we reached the end of substr, it means it's a subsequence of s
        return i == substr.length();
    }

    public boolean isSubsequence(String substr, String s) {
        int first = 0;
        for (int second = 0; second < s.length() && first < substr.length(); second++) {
            if(s.charAt(second) == substr.charAt(first)) {
                first++;
            }
        }
        return first == substr.length();
    }
}
