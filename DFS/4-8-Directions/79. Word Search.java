class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length, COLS = board[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (dfs(board, word, visited, ROWS, COLS, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, boolean[][] visited, int ROWS, int COLS, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != word.charAt(i) || visited[r][c]) {
            return false;
        }
        visited[r][c] = true;
        boolean res = (dfs(board, word, visited, ROWS, COLS, r + 1, c, i + 1) || dfs(board, word, visited, ROWS, COLS, r - 1, c, i + 1) || dfs(board, word, visited, ROWS, COLS, r, c + 1, i + 1) || dfs(board, word, visited, ROWS, COLS, r, c - 1, i + 1));
        
        visited[r][c] = false;
        return res;
    }
    
}
