package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem1268 {
    static void main() {

    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    TrieNode root = new TrieNode();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // важно для лексикографического порядка

        // строим Trie
        for (String product : products) {
            insert(product);
        }

        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;

        for (char c : searchWord.toCharArray()) {
            int idx = c - 'a';

            if (node != null) {
                node = node.children[idx];
            }

            if (node == null) {
                result.add(new ArrayList<>());
            } else {
                result.add(node.suggestions);
            }
        }

        return result;
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];

            if (node.suggestions.size() < 3) {
                node.suggestions.add(word);
            }
        }
    }
}
