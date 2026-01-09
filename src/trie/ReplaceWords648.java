package trie;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWords648 {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root = new TrieNode();
    public String replaceWords(List<String> dictionary, String sentence) {
        for (String s : dictionary) {
            add(s);
        }

        String[] split = sentence.split(" ");
        List<String> res = new ArrayList<>();
        for (String s : split) {
            res.add(getRoot(s));
        }
        return String.join(" ", res);
    }

    public String getRoot(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return word;
            }

            prefix.append(c);
            node = node.children[idx];
            if(node.isEnd) {
                return prefix.toString();
            }
        }
        return word;
    }

    public void add(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }
}
