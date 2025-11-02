package twoPointers;

public class ReverseWordsString557 {

    public static void main(String[] args) {

    }


    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }

        // Удалим последний пробел
        return result.toString().trim();
    }
}
