package trie;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs677 {

    static void main() {
        insert("apple", 3);
        int sum1 = sum("ap");
        insert("app", 2);
        int sum2 = sum("ap");
    }

     static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int sum = 0;
    }

    private static final TrieNode root= new TrieNode();
    private static final Map<String, Integer> values = new HashMap<>();

    public static void insert(String key, int val) {
        int delta = val - values.getOrDefault(key, 0);
        values.put(key, val);

        TrieNode node = root;
        node.sum += delta;

        for (char c : key.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
            node.sum += delta;
        }
    }

    public static int sum(String prefix) {
        TrieNode node = root;

        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return 0;
            }
            node = node.children[idx];
        }

        return node.sum;
    }
}
