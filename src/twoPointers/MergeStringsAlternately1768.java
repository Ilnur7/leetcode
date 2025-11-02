package twoPointers;

public class MergeStringsAlternately1768 {
    public static void main(String[] args) {

    }

    public String mergeAlternately1(String word1, String word2) {
        int a = word1.length();
        int b = word2.length();

        StringBuilder s = new StringBuilder();
        int i = 0;
        while (i < a && i < b) {
            s.append(word1.charAt(i));
            s.append(word2.charAt(i));
            i++;
        }
        s.append(word1.substring(i));
        s.append(word2.substring(i));
        return s.toString();
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i++));
            }
            if (j < word2.length()) {
                sb.append(word2.charAt(j++));
            }
        }

        return sb.toString();
    }
}
