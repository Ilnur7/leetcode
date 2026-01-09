package trie;

public class DesignAddSearchWordsDataStructure211 {
    static void main() {

    }

    class WordDictionary {

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEnd = false;
        }

        private TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
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

        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        private boolean dfs(String word, int idx, TrieNode node) {
            if (node == null) return false;
            if (idx == word.length()) return node.isEnd;

            char c = word.charAt(idx);

            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null &&
                        dfs(word, idx + 1, node.children[i])) {
                        return true;
                    }
                }
                return false;
            } else {
                return dfs(word, idx + 1, node.children[c - 'a']);
            }
        }
    }

}
