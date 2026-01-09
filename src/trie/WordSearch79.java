package trie;

public class WordSearch79 {
    static void main() {

    }

    char[][] board;
    String word;
    int row;
    int col;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;

        this.board = board;
        this.word = word;
        this.row = board.length;
        this.col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int idx) {
        if (idx == word.length()) return true;

        if (i < 0 || i >= row || j < 0 || j >= col ||
            board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found =
            dfs(i + 1, j, idx + 1) ||
                dfs(i - 1, j, idx + 1) ||
                dfs(i, j + 1, idx + 1) ||
                dfs(i, j - 1, idx + 1);

        board[i][j] = temp;
        return found;
    }
}
